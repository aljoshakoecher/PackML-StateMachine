package states.impl;

import statemachine.StateMachine;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link SuspendingState} denotes a transitive state that is entered on a suspend command. This command is typically issued when external
 * conditions prevent a machine from continuing execution (e.g. waiting for downstream machines). After executing the action the state machine will
 * transition to the {@link SuspendedState}
 */
public class SuspendingState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Start cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Suspending -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getActionInSuspending();
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new SuspendedState());
	}

}
