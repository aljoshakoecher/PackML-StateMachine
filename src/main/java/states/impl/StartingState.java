package states.impl;

import statemachine.StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link StartingState} denotes a transitive state that should make a machine ready for producing. After having completed a startup procedure,
 * the state machine will change to the {@link ExecuteState}.
 */
public class StartingState extends StoppableState {

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
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Starting);
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new ExecuteState());
	}

}
