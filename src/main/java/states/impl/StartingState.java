package states.impl;

import statemachine.Isa88StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link StartingState} denotes a transitive state that should make a machine ready for producing. After having completed a startup procedure,
 * the state machine will change to the {@link ExecuteState}.
 */
public class StartingState extends StoppableState {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		// Hold cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Starting -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(Isa88StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Starting);
		super.executeAction(actionToRun);
		
		// Make sure the current state is still Starting before going to Execute (could have been changed in the mean time).
		if (stateMachine.getState() instanceof StartingState) {
			stateMachine.setStateAndRunAction(new ExecuteState());
		}
	}

}
