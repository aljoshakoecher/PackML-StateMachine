package states.impl;

import statemachine.Isa88StateMachine;
import states.StoppableState;

/**
 * The {@link IdleState} denotes a waiting state that can be seen as the initial state of a machine that is ready to start production. A start command
 * has to be issued in order to start production and bring the state machine to the {@link StartingState}.
 */
public class IdleState extends StoppableState {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new StartingState());
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Suspend cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

}
