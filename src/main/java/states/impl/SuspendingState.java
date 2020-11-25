package states.impl;

import statemachine.Isa88StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link SuspendingState} denotes a transitive state that is entered on a suspend command. This command is typically issued when external
 * conditions prevent a machine from continuing execution (e.g. waiting for downstream machines). After executing the action the state machine will
 * transition to the {@link SuspendedState}
 */
public class SuspendingState extends StoppableState {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(Isa88StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Suspending);
		super.executeAction(actionToRun);

		// Make sure the current state is still execute before going to Completing (could have been changed in the mean time).
		if (stateMachine.getState() instanceof SuspendingState) {
			stateMachine.setStateAndRunAction(new SuspendedState());
		}
	}

}
