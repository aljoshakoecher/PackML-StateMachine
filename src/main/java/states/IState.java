package states;

import statemachine.StateMachine;
import states.impl.AbortedState;
import states.impl.AbortingState;
import states.impl.ClearingState;
import states.impl.ExecuteState;
import states.impl.HeldState;
import states.impl.HoldingState;
import states.impl.IdleState;
import states.impl.ResettingState;
import states.impl.StoppedState;
import states.impl.StoppingState;
import states.impl.SuspendedState;
import states.impl.SuspendingState;
import states.impl.UnholdingState;
import states.impl.UnsuspendingState;

/**
 * Defines all commands of an ISA 88 state machine
 */
public interface IState {

	/**
	 * The start command does only have an effect in {@link IdleState}. With this command, the state machine will change to the {@link ExecuteState}
	 * @param stateMachine A reference to the current {@link StateMachine} instance 
	 */
	public void start(StateMachine stateMachine);

	/**
	 * The hold command is used when interal reasons of a machine should bring it to an halt. Such reasons could be e.g. necessary refill of material.
	 * With this command, the state machine will transition to a {@link HoldingState} and eventually come to a full {@link HeldState}.
	 * @param stateMachine A reference to the current {@link StateMachine} instance 
	 */
	public void hold(StateMachine stateMachine);

	/**
	 * The unhold command brings the machine into an {@link UnholdingState} that eventually leads back to the {@link ExecuteState}. The hold command
	 * should be used when the internal reasons that brought a machine into a {@link HeldState} have been cleared.
	 * @param stateMachine A reference to the current {@link StateMachine} instance 
	 */
	public void unhold(StateMachine stateMachine);

	/**
	 * The suspend command is used when extenal reasons of a machine should bring it to an halt. Such reasons could be e.g. waiting for following
	 * machines to accept a workpiece. With this command, the state machine will transition to a {@link SuspendingState} and eventually come to a full
	 * {@link SuspendedState}.
	 * @param stateMachine A reference to the current {@link StateMachine} instance 
	 */
	public void suspend(StateMachine stateMachine);

	/**
	 * The unsuspend command brings the machine into an {@link UnsuspendingState} that eventually leads back to the {@link ExecuteState}. The
	 * unsuspend command should be used when the external reasons that brought a machine into a {@link SuspendedState} have been cleared.
	 * @param stateMachine A reference to the current {@link StateMachine} instance 
	 */
	public void unsuspend(StateMachine stateMachine);

	/**
	 * The reset command brings the machine into a {@link ResettingState} that eventually leads back to the {@link IdleState}. The reset command can
	 * be used when the machine has been brought to a sudden halt (e.g. with stop or abort command)
	 * @param stateMachine A reference to the current {@link StateMachine} instance 
	 */
	public void reset(StateMachine stateMachine);

	/**
	 * The stop command can be triggered by an external system such as an MES. Stop brings the state machine to a {@link StoppingState} and from there
	 * to a {@link StoppedState}. The currently produced product should not be destroyed and production can continue after the machine has been reset.
	  * @param stateMachine A reference to the current {@link StateMachine} instance 
	 */
	public void stop(StateMachine stateMachine);

	/**
	 * The abort command can be triggered by an external system such as an MES. Abort brings the state machine to a sudden stop by transitioning to
	 * the {@link AbortingState} and eventually to the {@link AbortedState}. The machine is switched off, the currently produced product might have to
	 * be destroyed and production of it can not be continued.
	  * @param stateMachine A reference to the current {@link StateMachine} instance 
	 */
	public void abort(StateMachine stateMachine);

	/**
	 * After a machine has been brought to the {@link AbortedState}, a clear command can be used to bring it to a {@link ClearingState} to e.g. remove
	 * destroyed products. From the {@link ClearingState}, the machine will come to the {@link StoppedState} from which it then can be reset.
	  * @param stateMachine A reference to the current {@link StateMachine} instance 
	 */
	public void clear(StateMachine stateMachine);
	
}