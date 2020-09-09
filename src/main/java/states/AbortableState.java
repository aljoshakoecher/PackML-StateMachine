package states;

import statemachine.Isa88StateMachine;
import states.impl.AbortingState;

/**
 * Abstract super class of all ISA-88 states that can just be aborted but not stopped (i.e. Stopping, Clearing, Stopped).
 */
public abstract class AbortableState extends State {

	@Override
	public void abort(Isa88StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new AbortingState());
	}

	@Override
	public void stop(Isa88StateMachine stateMachine) {
	}
}
