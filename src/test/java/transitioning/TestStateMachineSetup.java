package transitioning;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import statemachine.Isa88StateMachine;
import statemachine.StateMachineBuilder;
import states.ActiveStateName;
import states.IStateAction;
public class TestStateMachineSetup {

	static IStateAction dummyAction;

	@BeforeAll
	static void setUp() {
		dummyAction = new IStateAction() {
			@Override
			public void execute() {
				// simply do nothing here
			}
		};

	}

	
	@ParameterizedTest
	@EnumSource(ActiveStateName.class)
	void testActionSetup(ActiveStateName stateName) {
		Isa88StateMachine stateMachine = new StateMachineBuilder().withAction(dummyAction, stateName).build();
		IStateAction action = stateMachine.getStateActionManager().getAction(stateName);
		assertEquals(action, dummyAction, "dummyAction should be added to state action");
	}

}
