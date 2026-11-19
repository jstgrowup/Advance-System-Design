// The abstract keyword in Java is used when we want to create 
// a base class or method whose complete implementation 
// is left for child classes 


// Abstract means incomplete by design 

// An abstract class can define what should 
// exists while child classes descide how it should work


// Abstract Class --> Abstract ->abstract class Animal --> WE cannot create an abstract class


// Abstract method is a method that does not contain an implementations  

// Why use abstranct Methods ?
//  SUppose every animal makes and sound
// Dog --> bank 
// Cat -> <ewos
// Lio

abstract class Animal {
    abstract void sound();
}
// If we make a method called sound 
class Cat extends Animal {
    @Override
    vois sound() {
        System.out.println("Cat memos");
    }
}




abstract class Employee {
    Stirng name;

    Employee(String name) {

    }
}


class Development {
    
}
public class Demo {
    public static void main(String[] args) {
        
    }
}
