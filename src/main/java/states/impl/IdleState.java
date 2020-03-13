package states.impl;

import statemachine.StateMachine;
import states.StoppableState;

/**
 * The {@link IdleState} denotes a waiting state that can be seen as the initial state of a machine that is ready to start production. A start command
 * has to be issued in order to start production and bring the state machine to the {@link StartingState}.
 */
public class IdleState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new StartingState());
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Suspend cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Idle -> Do nothing except maybe giving a warning
	}

}
