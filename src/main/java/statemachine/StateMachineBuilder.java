package statemachine;

import states.ActiveStateName;
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
	 * Adds an {@link IStateAction} to a certain {@link State}. The {@link IStateAction} will be executed in that given {@link State}.
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link StartingState}
	 * @param stateName Name of the {@link State} that the action will be executed in.
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withAction(IStateAction action, ActiveStateName stateName) {
		switch (stateName) {
		case Starting:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Starting);
			break;
		case Execute:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Execute);
			break;
		case Completing:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Completing);
			break;
		case Holding:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Holding);
			break;
		case Unholding:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Unholding);
			break;
		case Suspending:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Suspending);
			break;
		case Unsuspending:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Unsuspending);
			break;
		case Stopping:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Stopping);
			break;
		case Clearing:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Clearing);
			break;
		case Aborting:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Aborting);
			break;
		case Resetting:
			this.stateMachine.getStateActionManager().setAction(action, ActiveStateName.Resetting);
			break;
		default:
			break;
		}
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link StartingState}. Alias for withAction(action, ActiveStateName.Starting).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link StartingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInStarting(IStateAction action) {
		this.withAction(action, ActiveStateName.Starting);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link ExecuteState}. Alias for withAction(action, ActiveStateName.Execute).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link ExecuteState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInExecute(IStateAction action) {
		this.withAction(action, ActiveStateName.Execute);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link CompletingState}. Alias for withAction(action, ActiveStateName.Completing).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link CompletingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInCompleting(IStateAction action) {
		this.withAction(action, ActiveStateName.Completing);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link SuspendingState}. Alias for withAction(action, ActiveStateName.Suspending).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link SuspendingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInSuspending(IStateAction action) {
		this.withAction(action, ActiveStateName.Suspending);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link UnsuspendingState}. Alias for withAction(action, ActiveStateName.Unsuspending).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link UnsuspendingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInUnsuspending(IStateAction action) {
		this.withAction(action, ActiveStateName.Unsuspending);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link HoldingState}. Alias for withAction(action, ActiveStateName.Holding).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link HoldingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInHolding(IStateAction action) {
		this.withAction(action, ActiveStateName.Holding);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link UnholdingState}. Alias for withAction(action, ActiveStateName.Unholding).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link UnholdingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInUnholding(IStateAction action) {
		this.withAction(action, ActiveStateName.Unholding);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link ResettingState}. Alias for withAction(action, ActiveStateName.Resetting).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link ResettingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInResetting(IStateAction action) {
		this.withAction(action, ActiveStateName.Resetting);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link StoppingState}. Alias for withAction(action, ActiveStateName.Stopping).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link StoppingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInStopping(IStateAction action) {
		this.withAction(action, ActiveStateName.Stopping);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link AbortingState}. Alias for withAction(action, ActiveStateName.Aborting).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link AbortingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInAborting(IStateAction action) {
		this.withAction(action, ActiveStateName.Aborting);
		return this;
	}

	/**
	 * Adds an {@link IStateAction} that is to be executed in {@link ClearingState}. Alias for withAction(action, ActiveStateName.Clearing).
	 * 
	 * @param action An instance of {@link IStateAction} that is executed in {@link ClearingState}
	 * @return This {@link StateMachineBuilder} instance to use for further construction operations
	 */
	public StateMachineBuilder withActionInClearing(IStateAction action) {
		this.withAction(action, ActiveStateName.Clearing);
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