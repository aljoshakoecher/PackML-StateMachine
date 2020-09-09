package transitioning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import statemachine.Isa88StateMachine;
import statemachine.StateMachineBuilder;
import states.impl.*;

/**
 * Simple test class that contains tests to check whether immediate inputs interrupt the state machine
 */
@TestMethodOrder(OrderAnnotation.class)
public class TestTransitioningWithoutActions {

	static Isa88StateMachine stateMachine;
	
	@BeforeAll
	static void testSimpleSetup() {
		stateMachine = new StateMachineBuilder().build();
	}

	@Test
	@Order(2)
	void testOtherInitialState() throws InterruptedException {
		stateMachine.start();
		stateMachine.abort();
		Thread.sleep(500);	// Wait to be safe, otherwise there is a race condition between state changes and assertion 
		assertTrue(stateMachine.getState() instanceof AbortedState, "State Machine should directly abort after starting and switch to AbortedState. Current state is " + stateMachine.getState());
	}



}
