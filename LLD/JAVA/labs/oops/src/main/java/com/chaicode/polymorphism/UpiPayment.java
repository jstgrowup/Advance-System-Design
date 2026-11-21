package com.chaicode.polymorphism;

/**
 * ChaiKart Checkout — UpiPayment
 *
 * <p>UPI is free for customers.
 * <ul>
 *   <li>Constructor {@code UpiPayment(double amount, String upiId)}: pass amount to the parent
 *     (already done) and store upiId.</li>
 *   <li>{@code getUpiId()}: plain getter.</li>
 *   <li>{@code method()}: {@code "UPI"}. No fee — do not override {@code fee()}, the parent's 0 is correct.</li>
 *   <li>{@code receipt()}: the parent's receipt followed by the UPI id — reuse {@code super.receipt()}:
 *     <pre>UPI | Amount: 250.00 | Fee: 0.00 | Total: 250.00 | UPI ID: chai@okaxis</pre></li>
 * </ul>
 */
public class UpiPayment extends Payment {

    String upiId;

    public UpiPayment(double amount, String upiId) {
        super(amount);
        // Your code here
    }

    public String getUpiId() {
        // Your code here
        return "";
    }

    @Override
    public String method() {
        // Your code here
        return "";
    }

    @Override
    public String receipt() {
        // Your code here
        return "";
    }
}
