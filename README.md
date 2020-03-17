[![Maven Central](https://img.shields.io/maven-central/v/com.github.aljoshakoecher/isa88-state-machine.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.aljoshakoecher%22%20AND%20a:%22isa88-state-machine%22)

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

#####  withActionInStarting(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Starting' state.

##### withActionInExecute(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Execute' state.

##### withActionInCompleting(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Completing' state.

##### withActionInSuspending(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Suspending' state.

##### withActionInUnsuspending(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Unsuspending' state.

##### withActionInHolding(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Holding' state.

##### withActionInUnholding(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Unholding' state.

##### withActionInAborting(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Aborting' state.

##### withActionInClearing(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Clearing' state.

##### withActionInStopping(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Stopping' state.

##### withActionInResetting(IStateAction action)
Sets action to be the action that is going to be executed when the state machine is in 'Resetting' state.

### Getting notified on state changes
Work in progress, coming soon


## Usage
With Maven, it's very easy to use this library in your own projects. Releases are published to the Maven Central Repo, snapshot version can be obtained from Sonatype.

### Releases
Releases can be found on the Maven Central repository. Just add this dependency to your pom.xml:

```xml
<dependency>
	<groupId>com.github.aljoshakoecher</groupId>
	<artifactId>isa88-state-machine</artifactId>
	<version>1.0.0</version>
</dependency>
```

### Snapshots
Make sure to add the Sonatype repo to your POM if you want to grab a snapshot version:

```
<repository>
    <id>oss-sonatype</id>
    <name>oss-sonatype</name>
    <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
</repository>
```

### Building from source
This project is built with Maven. You can simply build this library from source if you have Maven installed. Clone or download this repository and run
`mvn clean install` from the project root.

## Disclaimer
Please note that the figure above and all definitions of states and transitions have been taken from the [OMAC PackML Implementation Guide](http://omac.org/wp-content/uploads/2016/11/PackML_Unit_Machine_Implementation_Guide-V1-00.pdf) for ISA 88. 
