package states.impl;

import statemachine.Isa88StateMachine;
import states.ActiveStateName;
import states.IStateAction;
import states.StoppableState;

/**
 * The {@link ExecuteState} denotes a transitive state that contains the main execution actions that are responsible for actual production. After
 * completing execution, the state machine will change to the {@link CompletingState}.
 */
public class ExecuteState extends StoppableState {

	@Override
	public void start(Isa88StateMachine stateMachine) {
		// Start cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void hold(Isa88StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new HoldingState());
	}

	@Override
	public void unhold(Isa88StateMachine stateMachine) {
		// Unhold cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void suspend(Isa88StateMachine stateMachine) {
		stateMachine.setStateAndRunAction(new SuspendingState());
	}

	@Override
	public void unsuspend(Isa88StateMachine stateMachine) {
		// Unsuspend cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void reset(Isa88StateMachine stateMachine) {
		// Reset cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void clear(Isa88StateMachine stateMachine) {
		// Clear cannot be fired from Execute -> Do nothing except maybe giving a warning
	}

	@Override
	public void executeActionAndComplete(Isa88StateMachine stateMachine) {
		IStateAction actionToRun = stateMachine.getStateActionManager().getAction(ActiveStateName.Execute);
		super.executeAction(actionToRun);
		
		// TODO: Make this nicer, e.g. by executing a "stateComplete" on the current state
		if (stateMachine.getState() instanceof ExecuteState) {
			stateMachine.setStateAndRunAction(new CompletingState());
		}
	}

}
