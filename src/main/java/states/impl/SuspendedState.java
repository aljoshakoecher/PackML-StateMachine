package states.impl;

import statemachine.StateMachine;
import states.StoppableState;

/**
 * The {@link SuspendedState} denotes a waiting state that is typically entered when external conditions prevent a machine from continuing execution. An
 * unsuspend command has to be issued in order to bring the state machine back to the {@link ExecuteState}.
 */
public class SuspendedState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void suspend(StateMachine stateMachine) {
		// Suspend cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void unsuspend(StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new UnsuspendingState());
	}
	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void stop(StateMachine stateMachine) {
		// Stop cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void abort(StateMachine stateMachine) {
		// Abort cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}

}
