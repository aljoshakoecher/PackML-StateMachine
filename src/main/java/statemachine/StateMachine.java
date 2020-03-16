package statemachine;

import states.State;

public class StateMachine {

	private State currentState;
	private StateActionManager stateActionManager = new StateActionManager();

	/**
	 * Instantiates a new {@link StateMachine} with the a given initial state
	 * 
	 * @param initialState State that the state machine is in upon starting
	 */
	StateMachine(State initialState) {
		this.currentState = initialState;
	}

	/**
	 * Execute a start command. Can be used to transition from Idle to Execute
	 */
	public void start() {
		this.currentState.start(this);
	}

	/**
	 * Execute a hold command. Can be used to transition from Execute to Held
	 */
	public void hold() {
		this.currentState.hold(this);
	}

	/**
	 * Execute an unhold command. Can be used to transition from Held back to Execute
	 */
	public void unhold() {
		this.currentState.unhold(this);
	}

	/**
	 * Execute a suspend command. Can be used to transition Execute to Suspend
	 */
	public void suspend() {
		this.currentState.suspend(this);
	}

	/**
	 * Execute an unsuspend command. Can be used to transition from Suspended back to Execute
	 */
	public void unsuspend() {
		this.currentState.unsuspend(this);
	}

	/**
	 * Execute a reset command. Can be used to transition from Complete or Stopped back to Idle
	 */
	public void reset() {
		this.currentState.reset(this);
	}

	/**
	 * Execute a stop command. Can be used to transition from all 'normal' states to Stopped
	 */
	public void stop() {
		this.currentState.stop(this);
	}

	/**
	 * Execute an abort command. Can be used to transition from all 'normal' and 'stopping'-states to Aborted
	 */
	public void abort() {
		this.currentState.abort(this);
	}

	/**
	 * Execute a clear command. Can be used to transition from Aborted to Stopped
	 */
	public void clear() {
		this.currentState.clear(this);
	}

	/**
	 * Returns the current state of this state machine
	 * 
	 * @return The current state instance
	 */
	public State getState() {
		return this.currentState;
	}

	/**
	 * Sets the current state of the StateMachine
	 * @param state The new state that will be set as the current state
	 */
	protected void setState(State state) {
		this.currentState = state;
	}
	
	/**
	 * Sets the current state of the StateMachine and runs this state's action
	 * @param state The new state that will be set as the current state
	 */
	public void setStateAndRunAction(State state) {
		this.currentState = state;
		
		new Thread(() -> {
			state.executeActionAndComplete(this);
		}).start();
	}

	/**
	 * Returns the {@link StateActionManager} of this state machine
	 * 
	 * @return This state machine's state manager instance
	 */
	public StateActionManager getStateActionManager() {
		return this.stateActionManager;
	}

}
