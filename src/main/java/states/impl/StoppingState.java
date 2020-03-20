package states.impl;

import statemachine.StateMachine;
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
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Start cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Stopping -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Stopping);
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new StoppedState());
	}

}
