package states.impl;

import statemachine.StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link CompletingState} denotes a transitive state that can be used to bring production to an end (e.g. when the specified number of products
 * have been produced). After the completing action has been executed, the state machine will change to the {@link ExecuteState}.
 */
public class CompletingState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Completing -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Completing -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Completing -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Start cannot be fired from Completing -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Completing -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Completing -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Completing -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Completing);
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new CompleteState());
	}

}
