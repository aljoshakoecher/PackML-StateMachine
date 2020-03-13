package states.impl;

import statemachine.StateMachine;
import states.AbortableState;
import states.IStateAction;

/**
 * The {@link ClearingState} denotes a transitive state that can be used to clear a machine from damaged products after it was aborted. After the
 * clearing action has been executed, the state machine will change to the {@link StoppedState}.
 */
public class ClearingState extends AbortableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Suspend cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void stop(StateMachine stateMachine) {
		// Stop cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getActionInClearing();
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new StoppedState());
	}

}
