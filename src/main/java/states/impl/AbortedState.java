package states.impl;

import statemachine.StateMachine;
import states.State;

/**
 * The {@link AbortedState} denotes a state in which the machine has been brought to a sudden halt. A
 * clear-command is necessary to transition to {@link StoppedState}.
 */
public class AbortedState extends State {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Suspend cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void stop(StateMachine stateMachine) {
		// Stop cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void abort(StateMachine stateMachine) {
		// Abort cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new ClearingState());
	}

}
