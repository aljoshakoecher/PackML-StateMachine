package states.impl;

import statemachine.Isa88StateMachine;
import states.StoppableState;

/**
 * The {@link SuspendedState} denotes a waiting state that is typically entered when external conditions prevent a machine from continuing execution. An
 * unsuspend command has to be issued in order to bring the state machine back to the {@link ExecuteState}.
 */
public class SuspendedState extends StoppableState {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Suspend cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new UnsuspendingState());
	}
	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}
	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Suspended -> Do nothing except maybe giving a warning
	}

}
