package states.impl;

import statemachine.StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link ExecuteState} denotes a transitive state that contains the main execution actions that are responsible for actual production. After
 * completing execution, the state machine will change to the {@link CompletingState}.
 */
public class ExecuteState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new HoldingState());
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new SuspendingState());
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Execute);
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new CompletingState());
	}

}
