package statemachine;

import states.ActiveStateName;
import states.IStateAction;
import states.NullStateAction;

public class StateActionManager {

	IStateAction actionInStarting = new NullStateAction();
	IStateAction actionInExecute = new NullStateAction();
	IStateAction actionInCompleting = new NullStateAction();
	IStateAction actionInSuspending = new NullStateAction();
	IStateAction actionInUnsuspending = new NullStateAction();
	IStateAction actionInHolding = new NullStateAction();
	IStateAction actionInUnholding = new NullStateAction();
	IStateAction actionInResetting = new NullStateAction();
	IStateAction actionInStopping = new NullStateAction();
	IStateAction actionInAborting = new NullStateAction();
	IStateAction actionInClearing = new NullStateAction();

	
	public IStateAction getAction(ActiveStateName stateName) {
		switch (stateName) {
		case Starting:
			return this.actionInStarting;
		case Execute:
			return this.actionInExecute;
		case Completing:
			return this.actionInCompleting;
		case Holding:
			return this.actionInHolding;
		case Unholding:
			return this.actionInUnholding;
		case Suspending:
			return this.actionInSuspending;
		case Unsuspending:
			return this.actionInUnsuspending;
		case Stopping:
			return this.actionInStopping;
		case Clearing:
			return this.actionInClearing;
		case Aborting:
			return this.actionInAborting;
		case Resetting:
			return this.actionInResetting;
		default:
			return null;
		} 
	}
	
	
	public void setAction(IStateAction action, ActiveStateName stateName) {
		switch (stateName) {
		case Starting:
			this.actionInStarting = action;
			break;
		case Execute:
			this.actionInExecute = action;
			break;
		case Completing:
			this.actionInCompleting = action;
			break;
		case Holding:
			this.actionInHolding = action;
			break;
		case Unholding:
			this.actionInUnholding = action;
			break;
		case Suspending:
			this.actionInSuspending = action;
			break;
		case Unsuspending:
			this.actionInUnsuspending = action;
			break;
		case Stopping:
			this.actionInStopping = action;
			break;
		case Clearing:
			this.actionInClearing = action;
			break;
		case Aborting:
			this.actionInAborting = action;
			break;
		case Resetting:
			this.actionInResetting = action;
			break;
		default:
			break;
		}
	}
	
}
