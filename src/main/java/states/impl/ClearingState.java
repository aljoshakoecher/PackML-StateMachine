package states.impl;

import statemachine.Isa88StateMachine;
import states.AbortableState;
import states.ActiveStateName;
import states.IStateAction;

/**
 * The {@link ClearingState} denotes a transitive state that can be used to clear a machine from damaged products after it was aborted. After the
 * clearing action has been executed, the state machine will change to the {@link StoppedState}.
 */
public class ClearingState extends AbortableState {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Suspend cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void stop(Isa88StateMachine stateMachine) {
		// Stop cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(Isa88StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Clearing);
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new StoppedState());
	}

}
