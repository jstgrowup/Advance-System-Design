
// extract the supports 
abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;

    }

    abstract void work();
}

class Developer extends Employee {
    public Developer(String name) {
        super(name);
    }
}