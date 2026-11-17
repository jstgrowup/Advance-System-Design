// Encapsulation is the praactice of bundling data and the methods 
// that operate on that data inside a class while 
// restricting direct access to the internal state 
// Data Hiding  --> private  --> Use private fields to prevent direct access from outside the class 
// 
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

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.balance = 1000;
        account.balance = -5000;
        System.out.println(account.balance);
    }
}