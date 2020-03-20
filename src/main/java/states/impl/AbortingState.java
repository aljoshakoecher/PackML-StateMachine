package states.impl;

import statemachine.StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.State;

/**
 * The {@link AbortingState} denotes a transitive state that should bring a machine to a sudden halt. Damages on products have to be expected. From Aborting, no
 * commands are accepted. After executing its action, the state machine will change to the {@link AbortedState}.
 */
public class AbortingState extends State {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Suspend cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void stop(StateMachine stateMachine) {
		// Stop cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void abort(StateMachine stateMachine) {
		// Abort cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Aborting);
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new AbortedState());
	}

}
