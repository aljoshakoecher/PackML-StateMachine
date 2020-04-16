package statemachine;

import states.IState;

/**
 * Defines an Observer that can be attached to a state machine in order to get notified on state changes
 */
public interface IStateChangeObserver {

	/**
	 * Gets called every time the state of a state machine changes
	 * @param newState The new state that the state machine is in.
	 */
	public void onStateChanged(IState newState);
}
