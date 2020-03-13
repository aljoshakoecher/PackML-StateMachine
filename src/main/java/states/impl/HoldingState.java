package states.impl;

import statemachine.StateMachine;
import states.IStateAction;
import states.State;
import states.StoppableState;

/**
 * The {@link HoldingState} denotes a transitive state that brings a machine to a stop when internal conditions prevent further production. After
 * having completed holding procedure, the state machine will change to the {@link HeldState}.
 */
public class HoldingState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Holding -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Holding -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		// Unhold cannot be fired from Holding -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Start cannot be fired from Holding -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Holding -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Holding -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Holding -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getActionInHolding();
		super.executeAction(actionToRun);

		State nextState = new HeldState();
		stateMachine.setStateAndRunAction(nextState);
	}

}
