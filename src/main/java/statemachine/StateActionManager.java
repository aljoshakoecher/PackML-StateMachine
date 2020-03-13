package statemachine;

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

	
	/**
	 * @return the actionInStarting
	 */
	public IStateAction getActionInStarting() {
		return actionInStarting;
	}

	/**
	 * @param actionInStarting the actionInStarting to set
	 */
	protected void setActionInStarting(IStateAction actionInStarting) {
		this.actionInStarting = actionInStarting;
	}

	/**
	 * @return the actionInExecute
	 */
	public IStateAction getActionInExecute() {
		return actionInExecute;
	}

	/**
	 * @param actionInExecute the actionInExecute to set
	 */
	protected void setActionInExecute(IStateAction actionInExecute) {
		this.actionInExecute = actionInExecute;
	}

	/**
	 * @return the actionInCompleting
	 */
	public IStateAction getActionInCompleting() {
		return actionInCompleting;
	}

	/**
	 * @param actionInCompleting the actionInCompleting to set
	 */
	protected void setActionInCompleting(IStateAction actionInCompleting) {
		this.actionInCompleting = actionInCompleting;
	}

	/**
	 * @return the actionInSuspending
	 */
	public IStateAction getActionInSuspending() {
		return actionInSuspending;
	}

	/**
	 * @param actionInSuspending the actionInSuspending to set
	 */
	protected void setActionInSuspending(IStateAction actionInSuspending) {
		this.actionInSuspending = actionInSuspending;
	}

	/**
	 * @return the actionInUnsuspending
	 */
	public IStateAction getActionInUnsuspending() {
		return actionInUnsuspending;
	}

	/**
	 * @param actionInUnsuspending the actionInUnsuspending to set
	 */
	protected void setActionInUnsuspending(IStateAction actionInUnsuspending) {
		this.actionInUnsuspending = actionInUnsuspending;
	}

	/**
	 * @return the actionInHolding
	 */
	public IStateAction getActionInHolding() {
		return actionInHolding;
	}

	/**
	 * @param actionInHolding the actionInHolding to set
	 */
	protected void setActionInHolding(IStateAction actionInHolding) {
		this.actionInHolding = actionInHolding;
	}

	/**
	 * @return the actionInUnholding
	 */
	public IStateAction getActionInUnholding() {
		return actionInUnholding;
	}

	/**
	 * @param actionInUnholding the actionInUnholding to set
	 */
	protected void setActionInUnholding(IStateAction actionInUnholding) {
		this.actionInUnholding = actionInUnholding;
	}

	/**
	 * @return the actionInResetting
	 */
	public IStateAction getActionInResetting() {
		return actionInResetting;
	}

	/**
	 * @param actionInResetting the actionInResetting to set
	 */
	protected void setActionInResetting(IStateAction actionInResetting) {
		this.actionInResetting = actionInResetting;
	}

	/**
	 * @return the actionInStopping
	 */
	public IStateAction getActionInStopping() {
		return actionInStopping;
	}

	/**
	 * @param actionInStopping the actionInStopping to set
	 */
	protected void setActionInStopping(IStateAction actionInStopping) {
		this.actionInStopping = actionInStopping;
	}

	/**
	 * @return the actionInAborting
	 */
	public IStateAction getActionInAborting() {
		return actionInAborting;
	}

	/**
	 * @param actionInAborting the actionInAborting to set
	 */
	protected void setActionInAborting(IStateAction actionInAborting) {
		this.actionInAborting = actionInAborting;
	}

	/**
	 * @return the actionInClearing
	 */
	public IStateAction getActionInClearing() {
		return actionInClearing;
	}

	/**
	 * @param actionInClearing the actionInClearing to set
	 */
	protected void setActionInClearing(IStateAction actionInClearing) {
		this.actionInClearing = actionInClearing;
	}

}
