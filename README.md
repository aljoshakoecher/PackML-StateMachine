# Java ISA88-StateMachine
A Java implementation of the state machine standardized in ISA 88. The state machine guarantees that only transitions that only 'valid' transitions can be executed. Have a look at the following figure which depicts the state machine of ISA 88:

![State machine as defined in ISA 88 (figure taken from http://omac.org/wp-content/uploads/2016/11/PackML_Unit_Machine_Implementation_Guide-V1-00.pdf](https://github.com/aljoshakoecher/ISA88-StateMachine/blob/documentation/images/documentation/isa88-state-machine.png?raw=true)

As you can see in the figure, the state machine defines states and transitions that can be fired on certain states. Here are some examples:
* A 'start'-transition only brings the state machine to the 'Starting' state when it is currently in 'Idle' state
* After production of an order has been completed, the state machine will change its current state to 'Complete'. It can only be reset from this state. 
* When you fire a 'stop'-transition while being in 'Stopped' state, nothing happens
The state machine makes sure that no invalid transitions can be fired.

## Documentation
### Simple state machine without actions
To use the simplest version of the state machine in your code, you simply obtain an instance from the state machine builder. This state machine will then be in 'Idle' state and you can invoke the transitions shown in the figure above. Note that this simple state machine can just be used to simulate the state machine behavior.

```Java
// necessary imports
import statemachine.StateMachine;
import statemachine.StateMachineBuilder;
import states.IStateAction;
import states.State;
import states.impl.*;


// somewhere in you code, you can setup the most simple state machine (initial state will be 'Idle')
stateMachine = new StateMachineBuilder().build();

// you can then invoke the ISA88-transitions on this state machine:
stateMachine.start();
stateMachine.suspend();
stateMachine.stop();
// ...
// see figure for more transitions
```

You can also create a state machine with a different initial state than 'Idle'. This can be done with the `withInitialState(State s)`-function of the builder. Simply pass in the state you want to have as the initial state to that function.

```java
stateMachine = new StateMachineBuilder().withInitialState(new StoppedState()).build();
```

### Creating a real state machine that executes actions
The state machine of ISA88 allows for executing actions in all active states. You can create arbitrary actions and pass them to the state machine to let the state machine execute these actions in the correct states. To implement your own actions, simply implement the interface `IStateAction` as shown here:

```Java
import states.IStateAction;

public class ExampleActionInStarting implements IStateAction {

	@Override
	public void execute() {
		System.out.println("Starting up whatever you are working with");
		// You can do what you want in here...
	}

}

```

Your actions can be passed in while creating a state machine instance. For example, you could pass in this `ExampleStartingAction` as the action that is executed while the state machine is in state 'Starting':

```Java
stateMachine = new StateMachineBuilder().withActionInStarting(new ExampleActionInStarting()).build();
```

You may use one or more of the following functions of the StateMachineBuilder:
* withActionInStarting(IStateAction action)
* withActionInExecute(IStateAction action)
* withActionInCompleting(IStateAction action)
* withActionInSuspending(IStateAction action)
* withActionInUnsuspending(IStateAction action)
* withActionInHolding(IStateAction action)
* withActionInUnholding(IStateAction action)
* withActionInAborting(IStateAction action)
* withActionInClearing(IStateAction action)
* withActionInStopping(IStateAction action)
* withActionInResetting(IStateAction action)

### Getting notified on state changes
Work in progress, coming soon


## Usage
It's very easy to use this library in your own projects. If you're working with Maven, simply add this dependency to the `<dependencies>` in you pom.xml.

```xml
<dependency>
   <groupId>de.hsu-hh.aut</groupId>
	<artifactId>isa88-state-machine</artifactId>
	<version>1.0.0</version>
</dependency>
```

### Releases
I'm currently working on publishing releases to the Sonatype Maven repo. Coming soon..

### Building from source
This project is built with Maven. You can simply build this library from source if you have Maven installed. Simply clone or download this repository and run
run `mvn clean install` from the project root.

## Disclaimer
Please note that the figure above and all definitions of states and transitions have been taken from the [OMAC PackML Implementation Guide](http://omac.org/wp-content/uploads/2016/11/PackML_Unit_Machine_Implementation_Guide-V1-00.pdf) for ISA 88. 
