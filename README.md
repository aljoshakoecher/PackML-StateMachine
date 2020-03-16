# Java ISA88-StateMachine
A Java implementation of the state machine standardized in ISA 88. The state machine guarantees that only transitions that only 'valid' transitions can be executed. Have a look at the following figure which depicts the state machine of ISA 88:



## Usage
It's very easy to use this library in your own projects. If you're working with Maven, simply add this dependency to the `<dependencies>` in you pom.xml.
```
<dependency>
    <groupId>aut.de.hsu-hh.isa88</groupId>
    <artifactId>state-machine</artifactId>
    <version>0.0.1</version>
</dependency>
```

### Releases
I'm currently working on publishing releases to the Sonatype Maven repo. Coming soon..

### Building from source
This project is built with Maven. You can simply build this library from source if you have Maven installed. Simply clone or download this repository and run
run mvn clean install from the project root.
