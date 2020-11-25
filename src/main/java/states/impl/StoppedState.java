package states.impl;

import statemachine.Isa88StateMachine;
import states.AbortableState;

/**
 * The {@link StoppedState} denotes a state in which the machine is powered and stationary. Communications with other systems are functioning. A
 * reset-command will cause a transition from {@link StoppedState} to {@link ResettingState}.
 */
public class StoppedState extends AbortableState {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Stopped -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Stopped -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Stopped -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Suspend cannot be fired from Stopped -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Stopped -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new ResettingState());
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Stopped -> Do nothing except maybe giving a warning
	}

}
