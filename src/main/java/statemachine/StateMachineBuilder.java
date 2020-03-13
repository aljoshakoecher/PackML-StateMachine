package statemachine;

import states.IStateAction;
import states.State;
import states.impl.*;

/**
 * Builder class that is in charge of constructing a properly set up {@link StateMachine}
 */
public class StateMachineBuilder {

	private StateMachine stateMachine;

	public StateMachineBuilder() {
		this.stateMachine = new StateMachine(new IdleState());
	}

	/**
	 * Construct a state machine with an action that is to be executed in {@link StartingState}
	 * 
	 * @param action Action that is executed in {@link StartingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */

	/**
	 * Constructs a state machine with a special initial state
	 * 
	 * @param initialState The state that is to be the initial state of the state machine
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withInitialState(State initialState) {
		this.stateMachine.setState(initialState);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link StartingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link StartingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInStarting(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInStarting(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link ExecuteState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link ExecuteState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInExecute(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInExecute(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link CompletingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link CompletingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInCompleting(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInCompleting(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link SuspendingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link SuspendingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInSuspending(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInSuspending(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link UnsuspendingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link UnsuspendingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInUnsuspending(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInUnsuspending(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link HoldingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link HoldingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInHolding(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInHolding(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link UnholdingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link UnholdingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInUnholding(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInUnholding(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link ResettingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link ResettingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInResetting(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInResetting(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link StoppingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link StoppingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInStopping(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInStopping(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link AbortingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link AbortingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInAborting(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInAborting(action);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link ClearingState}
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link ClearingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInClearing(IStateAction action) {
		this.stateMachine.getStateActionManager().setActionInClearing(action);
		return this;
	}

	/**
	 * Finishes building the {@link StateMachine} and returns a fresh instance with the given attributes
	 * 
	 * @return Fresh instance of {@link StateMachine}
	 */
	public StateMachine build() {
		return this.stateMachine;
	}
}