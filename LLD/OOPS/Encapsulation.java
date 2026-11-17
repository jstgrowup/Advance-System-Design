// Encapsulation is the praactice of bundling data and the methods 
// that operate on that data inside a class while 
// restricting direct access to the internal state 
// Data Hiding  --> private  --> Use private fields to prevent direct access from outside the class 
// Dont give direct access to the data 
// It bundles state and behaiviour together and protects the object internal state useing controlled acess together
public class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if(amount>0&& amount<=balance){
            balance -= amount;
        }
    }

}

class Student {
    private int marks;

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid");
        }
    }
     public  int getMarks() {
         return marks;
    }

}
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(3000); 
        account.withdraw(5000);
        System.out.println(account.getBalance());
        Student s1 = new Student();
        s1.setMarks(83);
        s1.getMarks();
    }
}