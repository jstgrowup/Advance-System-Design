# Foundation

- Java is a high-level, object-oriented, platform-independent programming language developed by James.
- Java -> **WORA** (Write Once, Run Anywhere) -> platform => OS and proc.
- Why Java? -> C and C++ were not platform independent, that's why Java.
- Java provides portability.
- Source --> Compiler --> Machine Code
- For Java: Source --> Compiler --> Bytecode (Platform independent) --> Machine Code. That machine should have a JVM.
- Simplicity and security

## Bytecode

- When Java code is compiled, it is not converted directly into machine code.
- `source.java` --> `javac` (Java compiler) --> `bytecode.class` (the extension is `.class`)

## JVM Architecture

- `source.java` --> `javac` (Java compiler) --> `bytecode.class` (the extension is `.class`) --> Java Virtual Machine
- The JVM has:
  - **Class loader:** it loads the `.class` into memory.
  - **Memory areas**
  - **Execution engine** -> JIT compiler and interpreter
  - **Garbage collector**
- --> These will convert that to machine code.

## JDK, JRE, JVM Relationship

### JDK

- Java Development Kit
- It provides JRE, Compiler, Debugger, Java docs, Development tools.

### JRE

- Java Runtime Environment
- Class libraries, like print or something like `console.log`.

`JDK` --> `JRE` --> `JVM`

## Java Editions

- **JSE** --> Java Standard Edition
- **JEE** --> Java Enterprise Edition
- **JME** --> Java Micro Environment
