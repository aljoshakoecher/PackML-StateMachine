package tests.transitioning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import statemachine.StateMachine;
import statemachine.StateMachineBuilder;
import states.IStateAction;
import states.State;
import states.impl.*;

@TestMethodOrder(OrderAnnotation.class)
class TestTransitioningWithDummyActions {

	private static StateMachine stateMachine;
	private final static int dummyActionTime = 500;

	@BeforeAll
	static void setUp() {
		// Create a dummy action that just pauses the thread
		IStateAction dummyAction = new IStateAction() {
			@Override
			public void execute() {
				try {
					Thread.sleep(dummyActionTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		// setup a state machine with all actions being dummy actions
		stateMachine = new StateMachineBuilder().withActionInStarting(dummyAction).withActionInExecute(dummyAction)
				.withActionInCompleting(dummyAction).withActionInSuspending(dummyAction).withActionInUnsuspending(dummyAction)
				.withActionInHolding(dummyAction).withActionInUnholding(dummyAction).withActionInAborting(dummyAction)
				.withActionInClearing(dummyAction).withActionInStopping(dummyAction).withActionInResetting(dummyAction).build();
	}

	@Test
	@Order(1)
	void testSetup() {
		assertTrue(stateMachine.getState() instanceof IdleState, "After setup, state machine should be in IdleState");
	}

	@Test
	@Order(2)
	void testAbortFromIdle() {
		stateMachine.abort();
		State currentState = stateMachine.getState();
		assertTrue((currentState instanceof AbortingState), "Dummy action should lead to a delay, state machine should therefore be in Aborting");
	}

	@Test
	@Order(3)
	void waitForAbortedToBeReached() throws InterruptedException {
		waitForDummyActionToBeCompleted(1); // Wait for aborting
		assertTrue((stateMachine.getState() instanceof AbortedState),
				"After the aborting action has been executed, Aborted should have been reached");
	}

	@Test
	@Order(4)
	void abortAgain() {
		stateMachine.abort();
		assertTrue(stateMachine.getState() instanceof AbortedState, "State machine should stay in Aborted when abort is fired again");
	}

	@Test
	@Order(5)
	void testClearingWhenAborted() {
		stateMachine.clear();
		assertTrue(stateMachine.getState() instanceof ClearingState, "Machine should switch to ClearingState when clearing is issued from aborted");
	}

	@Test
	@Order(6)
	void testAbortFromClearing() {
		stateMachine.abort();
		assertTrue(stateMachine.getState() instanceof AbortingState, "Machine should switch to AbortingState when abort is fired while clearing ");
	}
	
	@Test
	@Order(7)
	void testClearingAndResettingFromAborting() throws InterruptedException {
		waitForDummyActionToBeCompleted(1); // wait for aborting
		stateMachine.clear();
		waitForDummyActionToBeCompleted(1); // wait for clearing
		stateMachine.reset();
		waitForDummyActionToBeCompleted(1); // wait for resetting
		assertTrue(stateMachine.getState() instanceof IdleState, "Machine should switch to IdleState when clearing and resetting from Aborted");
	}
	
	@Test
	@Order(8)
	void testStartingFromIdle() throws InterruptedException {
		stateMachine.start();
		assertTrue(stateMachine.getState() instanceof StartingState, "Machine should switch to StartingState when starting from Idle");
	}
	
	
	@Test
	@Order(9)
	void testStartingAndCompletingFromIdle() throws InterruptedException {
		waitForDummyActionToBeCompleted(3); // Wait for starting, executing and completing
		assertTrue(stateMachine.getState() instanceof CompleteState, "Machine should switch to CompleteState after transitioning through Starting, Execute and Completing");
	}
	
	@Test
	@Order(10)
	void testResettingToIdleFromComplete() throws InterruptedException {
		stateMachine.reset();
		waitForDummyActionToBeCompleted(1); // Wait for resetting
		assertTrue(stateMachine.getState() instanceof IdleState, "Machine should switch to IdleState after transitioning through Resetting");
	}
	
	@Test
	@Order(11)
	void testSuspendFromComplete() throws InterruptedException {
		stateMachine.start();
		waitForDummyActionToBeCompleted(1); // Wait for starting to be complete
		stateMachine.suspend();
		assertTrue(stateMachine.getState() instanceof SuspendingState, "Machine should switch to SuspendingState after when suspend is fired in ExecuteState");
	}
	
	
	@Test
	@Order(12)
	void testUnsuspendFromSuspend() throws InterruptedException {
		waitForDummyActionToBeCompleted(1); // Wait for suspending
		stateMachine.unsuspend();
		waitForDummyActionToBeCompleted(1); // Wait for unsuspending
		assertTrue(stateMachine.getState() instanceof ExecuteState, "Machine should go back to Execute after unsuspend is fired in SuspendedState");
	}
	
	
	
	private void waitForDummyActionToBeCompleted(int numberOfActionsToAwait) {
		try {
			Thread.sleep(numberOfActionsToAwait * dummyActionTime + 200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
