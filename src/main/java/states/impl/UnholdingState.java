package states.impl;

import statemachine.StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link UnholdingState} denotes a transitive state that is entered after the machine has been suspended and an unhold command has been issued. After executing the action the state
 * machine will transition back to the {@link ExecuteState}.
 */
public class UnholdingState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Unholding -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Unholding -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Unholding -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Start cannot be fired from Unholding -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Unholding -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Unholding -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Unholding -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Unholding);
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new ExecuteState());
	}

}
