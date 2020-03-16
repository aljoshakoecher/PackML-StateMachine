package states;

import statemachine.StateMachine;

public abstract class State implements IState {

	/**
	 * Execute an action, complete this state and transition to the next state 
	 * @param stateMachine The current state machine instance
	 */
	public void executeActionAndComplete(StateMachine stateMachine) {
		// Default implementation: Do nothing
	}
	
	/**
	 * Default of a simple runAction implementation. Could be overriden if e.g. an action has to run in a separate thread
	 * @param action {@link IStateAction} that is going to be executed
	 */
	protected void executeAction(IStateAction action) {
		action.execute();
	}
	

}
