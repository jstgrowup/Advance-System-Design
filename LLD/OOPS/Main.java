// Every Java program starts at `public static void main`. Run this class to run the program.
// Java comes from a typed, class-based world, so we first look at WHY classes exist:
// without them we need one parallel array per attribute.
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        car3.brand = "BMW";
        car2.brand = "MD";
        car1.brand = "JD";
        Student student = new Student();
        
    }

    // A class is a blueprint, like a Car design that needs an engine and seats.
    // From one blueprint we create many objects (a Maruti, a Ferrari, a Porsche).
    // This is a static nested class so main can create it directly with `new Student()`.
    
}
 class Car {
        String brand;
        String color;
        void drive() {
            System.out.println("driving the car");
        }
    }

    class Student {
        String name;
        int age;
}