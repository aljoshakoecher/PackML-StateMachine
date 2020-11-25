package states.impl;

import statemachine.Isa88StateMachine;
import states.AbortableState;
import states.ActiveStateName;
import states.IStateAction;

/**
 * The {@link StoppingState} denotes a transitive state that should bring a machine to a sudden halt. Contrary to actions in {@link AbortingState},
 * actions in {@link StoppingState} should not lead to product damages. After having executed the action in stopping, the state machine will
 * transition to the {@link StoppedState}.
 */
public class StoppingState extends AbortableState {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(Isa88StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Stopping);
		super.executeAction(actionToRun);

		// Make sure the current state is still Stopping before going to Stopped (could have been changed in the mean time).
		if (stateMachine.getState() instanceof StoppingState) {
			stateMachine.setStateAndRunAction(new StoppedState());
		}
	}

}
