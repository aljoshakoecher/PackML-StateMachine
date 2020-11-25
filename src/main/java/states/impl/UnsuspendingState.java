package states.impl;

import statemachine.Isa88StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link UnsuspendingState} denotes a transitive state that is entered after the machine has been suspended and an unsuspend command has been
 * issued. After executing the action the state machine will transition back to the {@link ExecuteState}.
 */
public class UnsuspendingState extends StoppableState {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Unsuspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Unsuspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Unsuspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Unsuspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Unsuspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Unsuspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Unsuspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(Isa88StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Unsuspending);
		super.executeAction(actionToRun);

		// Make sure the current state is still Unsuspending before going to Execute (could have been changed in the mean time).
		if (stateMachine.getState() instanceof UnsuspendingState) {
			stateMachine.setStateAndRunAction(new ExecuteState());
		}
	}

}
