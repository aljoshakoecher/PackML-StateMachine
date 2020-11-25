package states.impl;

import statemachine.Isa88StateMachine;
import states.State;

/**
 * The {@link AbortedState} denotes a state in which the machine has been brought to a sudden halt. A
 * clear-command is necessary to transition to {@link StoppedState}.
 */
public class AbortedState extends State {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Suspend cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void stop(Isa88StateMachine stateMachine) {
		// Stop cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void abort(Isa88StateMachine stateMachine) {
		// Abort cannot be fired from Aborted -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new ClearingState());
	}

}
