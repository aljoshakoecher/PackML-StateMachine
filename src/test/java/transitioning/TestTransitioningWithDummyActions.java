package transitioning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import statemachine.Isa88StateMachine;
import statemachine.StateMachineBuilder;
import states.IStateAction;
import states.State;
import states.impl.*;

@TestMethodOrder(OrderAnnotation.class)
class TestTransitioningWithDummyActions {

	private final static int dummyActionTime = 300;
	private static IStateAction dummyAction;

	@BeforeAll
	static void setUp() {
		// Create a dummy action that just pauses the thread
		dummyAction = new IStateAction() {
			@Override
			public void execute() {
				try {
					Thread.sleep(dummyActionTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

	}

	@Test
	@Order(1)
	void testSimpleSetup() {
		Isa88StateMachine stateMachine = new StateMachineBuilder().build();
		assertTrue(stateMachine.getState() instanceof IdleState, "After setup, state machine should be in IdleState");
	}

	@Test
	@Order(2)
	void testOtherInitialState() {
		// Setup machine in stopped state
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new StoppedState()).build();
		assertTrue(stateMachine.getState() instanceof StoppedState, "Machine should be in StoppedState");
	}

	@Test
	void testAbortFromIdle() {
		// Setup in any state, we just take suspended
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new SuspendedState()).withActionInAborting(dummyAction).build();
		stateMachine.abort();
		State currentState = stateMachine.getState();
		assertTrue((currentState instanceof AbortingState), "Dummy action should lead to a delay, state machine should therefore be in Aborting");
	}

	@Test
	void waitForAbortedToBeReached() throws InterruptedException {
		// Setup in any state, we just take complete
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new CompleteState()).withActionInAborting(dummyAction).build();
		stateMachine.abort();
		waitForDummyActionToBeCompleted(1); // Wait for aborting
		assertTrue((stateMachine.getState() instanceof AbortedState),
				"After the aborting action has been executed, Aborted should have been reached");
	}

	@Test
	void abortAgain() {
		// Setup in Aborted State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new AbortedState()).withActionInAborting(dummyAction).build();
		stateMachine.abort();
		assertTrue(stateMachine.getState() instanceof AbortedState, "State machine should stay in Aborted when abort is fired again");
	}

	@Test
	void testClearingWhenAborted() {
		// Setup in Aborted State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new AbortedState()).withActionInClearing(dummyAction).build();
		stateMachine.clear();
		assertTrue(stateMachine.getState() instanceof ClearingState, "Machine should switch to ClearingState when clearing is issued from aborted");
	}

	@Test
	void testAbortFromClearing() {
		// Setup in Aborted State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new AbortedState()).withActionInAborting(dummyAction)
				.withActionInClearing(dummyAction).build();
		stateMachine.clear();
		stateMachine.abort();
		assertTrue(stateMachine.getState() instanceof AbortingState, "Machine should switch to AbortingState when abort is fired while clearing ");
	}

	@Test
	void testClearingAndResettingFromAborting() throws InterruptedException {
		// Setup in Aborted State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new AbortedState()).withActionInClearing(dummyAction)
				.withActionInResetting(dummyAction).build();
		stateMachine.clear();
		waitForDummyActionToBeCompleted(1); // wait for clearing
		stateMachine.reset();
		waitForDummyActionToBeCompleted(1); // wait for resetting
		assertTrue(stateMachine.getState() instanceof IdleState, "Machine should switch to IdleState when clearing and resetting from Aborted");
	}

	@Test
	void testStartingFromIdle() throws InterruptedException {
		// Setup in Idle State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new IdleState()).withActionInStarting(dummyAction).build();
		stateMachine.start();
		assertTrue(stateMachine.getState() instanceof StartingState, "Machine should switch to StartingState when starting from Idle");
	}

	@Test
	void testStartingAndCompletingFromIdle() throws InterruptedException {
		// Setup in Idle State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new IdleState()).withActionInStarting(dummyAction)
				.withActionInExecute(dummyAction).withActionInCompleting(dummyAction).build();
		stateMachine.start();
		waitForDummyActionToBeCompleted(3); // Wait for starting, executing and completing
		assertTrue(stateMachine.getState() instanceof CompleteState,
				"Machine should switch to CompleteState after transitioning through Starting, Execute and Completing");
	}

	@Test
	void testResettingToIdleFromComplete() throws InterruptedException {
		// Setup in Complete State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new CompleteState()).withActionInResetting(dummyAction).build();
		stateMachine.reset();
		waitForDummyActionToBeCompleted(1); // Wait for resetting
		assertTrue(stateMachine.getState() instanceof IdleState, "Machine should switch to IdleState after transitioning through Resetting");
	}

	@Test
	void testSuspendFromComplete() throws InterruptedException {
		// Setup in Idle State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new IdleState()).withActionInStarting(dummyAction)
				.withActionInSuspending(dummyAction).withActionInExecute(dummyAction).build();
		stateMachine.start();
		waitForDummyActionToBeCompleted(1); // Wait for starting to be complete
		stateMachine.suspend();
		assertTrue(stateMachine.getState() instanceof SuspendingState,
				"Machine should switch to SuspendingState when suspend is fired in ExecuteState");
	}

	@Test
	void testUnsuspendFromSuspend() throws InterruptedException {
		// Setup in Execute State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new ExecuteState()).withActionInSuspending(dummyAction).withActionInUnsuspending(dummyAction).build();
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
