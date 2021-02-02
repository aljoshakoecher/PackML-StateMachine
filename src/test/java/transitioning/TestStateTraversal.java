package transitioning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import statemachine.IStateChangeObserver;
import statemachine.Isa88StateMachine;
import statemachine.StateMachineBuilder;
import states.IState;
import states.IStateAction;
import states.impl.IdleState;

public class TestStateTraversal {

	private final static int dummyActionTime = 3000;
	private IStateAction dummyAction = new DummyAction(dummyActionTime);

	// Set up an observer that collects all states that have been reached
	static class ExampleObserver implements IStateChangeObserver {
		List<String> stateList = new ArrayList<String>();

		@Override
		public void onStateChanged(IState newState) {
			String observedStateName = newState.getClass().getSimpleName();
			stateList.add(observedStateName + "_" + Thread.currentThread().getId());
		}

		public List<String> getStateList() {
			return this.stateList;
		}
	};

	@Test
	void testAbortingWhileStarting() throws InterruptedException {
		// Setup in Execute State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new IdleState()).withActionInStarting(dummyAction)
				.withActionInExecute(dummyAction).withActionInCompleting(dummyAction).build();
		ExampleObserver observer = new ExampleObserver();
		stateMachine.addStateChangeObserver(observer);
		// start and wait for execute
		stateMachine.start();
		waitForDummyActionToBeCompleted(1);

		stateMachine.abort();
		waitForDummyActionToBeCompleted(1); // Wait for aborting
		int numberOfStatesTraversed = observer.getStateList().size();
		assertEquals(4, numberOfStatesTraversed,
				"State machine should only traverse through 4 States Starting, Execute, Aborting, Aborted. States traversed: "
						+ observer.getStateList());
	}

	@Test
	void testAbortingWhileStopping() throws InterruptedException {
		// Setup in Execute State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new IdleState())
				.withActionInStarting(new PrintingAction("Starting", dummyActionTime))
				.withActionInExecute(new PrintingAction("Execute", dummyActionTime))
				.withActionInStopping(new PrintingAction("Stopping", dummyActionTime))
				.withActionInAborting(new PrintingAction("Aborting", dummyActionTime)).build();
		ExampleObserver observer = new ExampleObserver();
		stateMachine.addStateChangeObserver(observer);

		stateMachine.start(); // start and wait a bit for starting to execute its action
		waitForDummyActionToBeCompleted(0);

		stateMachine.stop(); // stop and wait a bit, then abort
		waitForDummyActionToBeCompleted(0);
		stateMachine.abort();

		waitForDummyActionToBeCompleted(1); // Wait for aborting and then get the number of states that have been traversed
		int numberOfStatesTraversed = observer.getStateList().size();

		assertEquals(4, numberOfStatesTraversed,
				"State machine should only traverse through the 4 states Starting, Stopping, Aborting, Aborted.  States traversed: "
						+ observer.getStateList());
	}

	@Test
	void testAbortingWhileStopped() throws InterruptedException {
		// Setup in Execute State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new IdleState())
				.withActionInStarting(new PrintingAction("Starting", dummyActionTime))
				.withActionInStopping(new PrintingAction("Stopping", dummyActionTime))
				.withActionInAborting(new PrintingAction("Aborting", dummyActionTime)).build();
		ExampleObserver observer = new ExampleObserver();
		stateMachine.addStateChangeObserver(observer);

		stateMachine.start(); // start and stop directly
		stateMachine.stop();
		waitForDummyActionToBeCompleted(1); // Wait for stopping
		stateMachine.abort();
		waitForDummyActionToBeCompleted(1); // Wait for aborting
		int numberOfStatesTraversed = observer.getStateList().size();
		assertEquals(5, numberOfStatesTraversed,
				"State machine should only traverse through the 5 states Starting, Stopping, Stopped, Aborting, Aborted.  States traversed: "
						+ observer.getStateList());
	}

	@Test
	void testStoppingWhileStopping() {
		// Setup in Execute State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new IdleState()).withActionInStopping(dummyAction).build();
		ExampleObserver observer = new ExampleObserver();
		stateMachine.addStateChangeObserver(observer);
		// stop and stop a couple of times directly again
		stateMachine.stop();
		stateMachine.stop();
		stateMachine.stop();
		stateMachine.stop();
		waitForDummyActionToBeCompleted(1); // Wait for stopping
		int numberOfStatesTraversed = observer.getStateList().size();
		assertEquals(2, numberOfStatesTraversed,
				"State machine should only traverse through the 2 states Stoppping and Stopped.  States traversed: " + observer.getStateList());
	}

	@Test
	void testCompleteTraversalWithActions() {
		// Setup in Idle State
		Isa88StateMachine stateMachine = new StateMachineBuilder().withInitialState(new IdleState())
				.withActionInStarting(dummyAction)
				.withActionInExecute(dummyAction)
				.withActionInCompleting(dummyAction)
				.withActionInResetting(dummyAction)
				.build();
		ExampleObserver observer = new ExampleObserver();
		stateMachine.addStateChangeObserver(observer);
		
		stateMachine.start();					// Start and wait for Starting, Execute and Completing
		waitForDummyActionToBeCompleted(3);
		
		stateMachine.reset();					// Reset and wait for Resetting
		waitForDummyActionToBeCompleted(1);
		
		int numberOfStatesTraversed = observer.getStateList().size();
		assertEquals(6, numberOfStatesTraversed,
				"State machine should do a full traversal through the 6 states Starting, Execute, Completing, Complete, Resetting, Idle.  States traversed: " + observer.getStateList());

	}

	/**
	 * Just waits for the dummyActionTime and a bit more to ensure an action has been completed
	 * 
	 * @param numberOfActionsToAwait
	 */
	private void waitForDummyActionToBeCompleted(int numberOfActionsToAwait) {
		try {
			Thread.sleep((long) (numberOfActionsToAwait * dummyActionTime + 0.2 * dummyActionTime));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
