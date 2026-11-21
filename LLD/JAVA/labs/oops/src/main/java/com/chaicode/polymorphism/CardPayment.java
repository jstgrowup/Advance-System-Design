package com.chaicode.polymorphism;

/**
 * ChaiKart Checkout — CardPayment
 *
 * <p>Card networks charge ChaiKart 2%, which is passed on to the customer.
 * <ul>
 *   <li>{@code method()}: {@code "CARD"}.</li>
 *   <li>{@code fee()}: 2% of the amount, rounded to 2 decimals:
 *     <pre>Math.round(amount * 2) / 100.0</pre>
 *     e.g. 1000 → 20.0, 333.33 → 6.67</li>
 * </ul>
 */
public class CardPayment extends Payment {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public String method() {
        // Your code here
        return "";
    }

    @Override
    public double fee() {
        // Your code here
        return 0;
    }
}
