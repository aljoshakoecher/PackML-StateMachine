package states.impl;

import statemachine.Isa88StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.State;

/**
 * The {@link AbortingState} denotes a transitive state that should bring a machine to a sudden halt. Damages on products have to be expected. From Aborting, no
 * commands are accepted. After executing its action, the state machine will change to the {@link AbortedState}.
 */
public class AbortingState extends State {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Suspend cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void stop(Isa88StateMachine stateMachine) {
		// Stop cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void abort(Isa88StateMachine stateMachine) {
		// Abort cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Aborting -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(Isa88StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Aborting);
		super.executeAction(actionToRun);

		stateMachine.setStateAndRunAction(new AbortedState());
	}

}
