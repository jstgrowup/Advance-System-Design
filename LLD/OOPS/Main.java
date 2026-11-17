
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        car3.brand = "BMW";
        car2.brand = "MD";
        car1.brand = "JD";
        Student s1 = new Student("suraj", 22);
        System.out.println(s1.age);
        // student.id = 232;
        s1.name = "suraj";
        

    }

    
    
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

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void study() {
            
        }
}

// Instance Field , static field , final field
// Methods defines the behaiviour or actions that an object can perform 
// Constructor is a special member of class used to initailize an object 
// 4 access levels
// 