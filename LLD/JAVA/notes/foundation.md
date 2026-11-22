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

```java
public class HelloWorld {
    public static void main(String[] args) {
        // public means
        System.out.println("Hello world");
    }
}
```

- `public` means accessible by the JVM.
- `main` is a special method name recognized by the JVM, which tries to execute it.

## Variables and Datatypes

- A variable is a named memory location used to store data.

```java
int age = 22;
```

### What is an identifier?

- It's a name given to a variable, class, method, package or interface.
- `class Student` ==> here `Student` is the identifier.

### Naming conventions

- camelCase, please.

### What is a datatype?

- It tells Java what type of data we will store there.

```java
datatype variableName = value;

int age = 21;
String name = "Suraj";
double price = 99.99;
```

### What is a statically typed language?

- The datatype of a variable must be declared before compilation.

### Types of datatypes

#### Primitive

1. **Integer**
   - `byte`, `short`, `int`, `long`
2. **Real number**
   - `float`, `double`
3. **Char**
4. **Boolean**

#### Non-primitive

- `String`
- Array
- Classes, interfaces
- Enums

Keywords

```java
public class HelloWorld {
    public static void main(String[] args) {
        // public means
        int age =21;
        // Its a variable
        double marks =99.9;
        char grade='A';
        boolean isPlaced=true;
        System.out.println(age);
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");

    }
}
```

Operators

1. Arithmetic
2. Realtionsal
3. Logical
4. Assignment
