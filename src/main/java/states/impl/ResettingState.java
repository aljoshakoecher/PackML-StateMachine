package states.impl;

import statemachine.StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link ResettingState} denotes a transitive state that brings a machine back to its {@link IdleState} after it had previously been stopped or
 * aborted.
 */
public class ResettingState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Start cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Resetting);
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new IdleState());
	}

}
