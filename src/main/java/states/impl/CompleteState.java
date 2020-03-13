package states.impl;

import statemachine.StateMachine;
import states.StoppableState;

/**
 * The {@link CompleteState} denotes a state in which the machine has completed production. In order to start the next order, a reset command is
 * necessary to transition to {@link IdleState}.
 */
public class CompleteState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Complete -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Complete -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Complete -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Suspend cannot be fired from Complete -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Complete -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new ResettingState());
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Clearing -> Do nothing except maybe giving a warning
	}

}
