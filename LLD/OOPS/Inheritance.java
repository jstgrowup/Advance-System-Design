// Inheritence allows one class to 
// acquire the fields and methods 
// of anotherclass.

// It promotes code reuse and 
// allows us to create a relationsip 
// between classes

// super refer to the immediate parent class
// It is commonly used to access the parents 

// Method overriding : Method overriding is the 
// Method overriding happens when a child class 
// provides its own implementing of a method 
// inherited from the parent class

class Animal {
    Animal(String name) {
        System.out.println(name);
    }
    void sound() {
        System.out.println("Animal sound");
    }
    void eat() {
        System.out.println("eating");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    @Override 
    void sound() {
        System.out.println("dog barks");
    }
    // Dog() {
    //     super("Dog");
    // }
    // void sound() {
    //     super.sound();
    // }
    // void bark() {
    //     System.out.println("Barking");
    // }
}
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.eat();
        dog.sound();
    }
}