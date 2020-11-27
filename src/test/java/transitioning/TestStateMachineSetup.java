package transitioning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import statemachine.Isa88StateMachine;
import statemachine.StateMachineBuilder;
import states.ActiveStateName;
import states.IStateAction;
public class TestStateMachineSetup {

	int dummyActionTime = 500;
	IStateAction dummyAction = new DummyAction(dummyActionTime);
	
	@ParameterizedTest
	@EnumSource(ActiveStateName.class)
	void testActionSetup(ActiveStateName stateName) {
		Isa88StateMachine stateMachine = new StateMachineBuilder().withAction(dummyAction, stateName).build();
		IStateAction action = stateMachine.getStateActionManager().getAction(stateName);
		assertEquals(action, dummyAction, "dummyAction should be added to state action");
	}

}
