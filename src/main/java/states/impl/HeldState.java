package states.impl;

import statemachine.StateMachine;
import states.StoppableState;

/**
 * The {@link HeldState} denotes a waiting state that is typically entered when internal conditions prevent a machine from continuing execution. An
 * unhold command has to be issued in order to bring the state machine to the {@link UnholdingState}.
 */
public class HeldState extends StoppableState {

	@Override
	public void start(StateMachine stateMachine) {
		// Start cannot be fired from Held -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(StateMachine stateMachine) {
		// Hold cannot be fired from Held -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new UnholdingState());
	}

	@Override
	public void suspend(StateMachine stateMachine) {
		// Suspend cannot be fired from Held -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(StateMachine stateMachine) {
		// Unsuspend cannot be fired from Held -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(StateMachine stateMachine) {
		// Reset cannot be fired from Held -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(StateMachine stateMachine) {
		// Clear cannot be fired from Held -> Do nothing except maybe giving a warning
	}

}
