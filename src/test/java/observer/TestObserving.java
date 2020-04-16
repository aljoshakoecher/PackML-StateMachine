package observer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import statemachine.IStateChangeObserver;
import statemachine.StateMachine;
import statemachine.StateMachineBuilder;
import states.IState;
import states.IStateAction;
import states.impl.IdleState;

@TestMethodOrder(OrderAnnotation.class)
class TestObserving {
	
	static class ExampleObserver implements IStateChangeObserver {
		public String observedStateName;
		@Override
		public void onStateChanged(IState newState) {
			System.out.println("State has changed, new State is: " + newState.getClass().getSimpleName());
			observedStateName = newState.getClass().getSimpleName();
		}
	};
	
	private final static int dummyActionTime = 300;
	private static IStateAction dummyAction;
	private static StateMachine stateMachine;
	private static ExampleObserver firstObserver;
	private static ExampleObserver secondObserver;

	@BeforeAll
	static void setUp() {
		firstObserver = new ExampleObserver();
		secondObserver = new ExampleObserver();
//		ExampleObserver secondObserver = new ExampleObserver();
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
		
		StateMachineBuilder builder = new StateMachineBuilder();
		stateMachine = builder.withActionInAborting(dummyAction).withActionInClearing(dummyAction).withActionInCompleting(dummyAction)
				.withActionInExecute(dummyAction).withActionInHolding(dummyAction).withActionInResetting(dummyAction).withActionInStarting(dummyAction)
				.withActionInStopping(dummyAction).withActionInSuspending(dummyAction).withActionInUnholding(dummyAction).withActionInUnsuspending(dummyAction)
				.build();

	}
	
	@Test
	@Order(1)
	void addFirstObserverAndTestStart() {
		stateMachine.addStateChangeObserver(firstObserver);
		stateMachine.start();
		assertEquals(firstObserver.observedStateName, "StartingState", "Observer should be notified that the state machine is now in Starting");
	}
	
	@Test
	@Order(2)
	void testResetWithFirstObserver() throws InterruptedException {
		Thread.sleep(dummyActionTime*4);		// Wait for execution of starting, execute, completing + safetyTime 
		stateMachine.reset();
		Thread.sleep(dummyActionTime*2);		// Wait for execution of resetting + safetyTime
		assertEquals(firstObserver.observedStateName, "IdleState", "Observer should be notified that the state machine is now in Idle");
	}
	
	
	@Test
	@Order(3)
	void addSecondObserverAndTestStart() {
		stateMachine.addStateChangeObserver(secondObserver);
		stateMachine.start();
		assertEquals(secondObserver.observedStateName, "StartingState", "Second observer should be notified that the state machine is now in Starting");
	}
	
	@Test
	@Order(4)
	void makeSureFirstObserverStillWorking() throws InterruptedException {
		Thread.sleep(dummyActionTime*4);		// Wait for execution of starting, execute, completing + safetyTime
		assertEquals(firstObserver.observedStateName, "CompleteState", "First observer should have tracked changes and should now be in CompleteState");
	}
	
	@Test
	@Order(5)
	void removeSecondObserverAndMakeSureFirstObserverStillWorking() throws InterruptedException {
		stateMachine.removeStateChangeObserver(secondObserver);
		stateMachine.reset();
		Thread.sleep(dummyActionTime*2);		// Wait for execution of resetting + safetyTime
		assertEquals(firstObserver.observedStateName, "IdleState", "First observer should now be in IdleState");
	}
	
	@Test
	@Order(6)
	void testSecondOberserverNoLongerNotified() throws InterruptedException {
		assertEquals(secondObserver.observedStateName, "CompleteState", "Second observer should not have been notified after removal and should still be in CompleteState");
	}
}