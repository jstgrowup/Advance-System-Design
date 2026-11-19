// Abstraction
abstract class Payments {
    abstract void pay(double amount);

    

}

class UPI extends Payment {
    @Override 
    void pay(double amount) {
        System.out.println();
    }
}
class Card extends Payment {
    @Override 
    void pay(double amount) {
        System.out.println();
    }
}
public class Payment {
    public static void main(String[] args) {
        Payment payment1 = new UPI();
        
    }
    
}
