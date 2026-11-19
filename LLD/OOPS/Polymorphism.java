// The same method call can behave differently depending on the 
// Object that is using it 


// The main idea of polymorphism 


// Lets day Dog , cat and cow they make sound rigght here we wont be making differen methods for there sounds 
public class Polymorphism {

    static class Animal {
        void sound() {
            System.out.println("Animal sound");
        }
    }

    static class Cat extends Animal {
        @Override
        void sound() {
            System.out.println("Cat");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound(); // Animal sound

        Animal cat = new Cat();
        cat.sound();

       
    }
}
// WE have a common type called Animal and it can represent different types
// Poly --> Many morphs --> Forms
// 

// Runtime polymorshism is the behaiviour is usually what we mean when talking about polymorphism in OOP
// this decision happens at runtime 



// Abstraction (Classes)
