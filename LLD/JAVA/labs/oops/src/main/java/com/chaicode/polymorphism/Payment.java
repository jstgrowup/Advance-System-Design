package com.chaicode.polymorphism;

/**
 * ChaiKart Checkout — Payment
 *
 * <p>ChaiKart's checkout accepts UPI, cards and cash-on-delivery. The checkout code only ever
 * talks to a {@code Payment} reference — {@code Payment p = new CardPayment(1000);} — and simply
 * calls {@code p.fee()}, {@code p.total()} and {@code p.receipt()}. Which version runs is decided at
 * RUNTIME by the actual object. That is runtime polymorphism.
 *
 * <p>Field {@code amount} is already declared.
 *
 * <p>Implement in {@code Payment} (the parent):
 * <ul>
 *   <li>Constructor {@code Payment(double amount)}: amount must be &gt; 0, otherwise throw
 *     {@code IllegalArgumentException}.</li>
 *   <li>{@code getAmount()}: plain getter.</li>
 *   <li>{@code method()}: return {@code "GENERIC"}.</li>
 *   <li>{@code fee()}: a generic payment has no fee — return 0.</li>
 *   <li>{@code total()}: {@code amount + fee()} — call {@code fee()} so the child's fee is used.</li>
 *   <li>{@code receipt()}: build it by calling {@code method()}, {@code fee()} and {@code total()}:
 *     <pre>String.format("%s | Amount: %.2f | Fee: %.2f | Total: %.2f", method(), amount, fee(), total())</pre>
 *     e.g. {@code GENERIC | Amount: 100.00 | Fee: 0.00 | Total: 100.00}</li>
 * </ul>
 *
 * <p>Then complete the children {@link UpiPayment}, {@link CardPayment}, {@link CashPayment} and the
 * {@link PaymentProcessor} — see their Javadoc.
 */
public class Payment {

    protected double amount;

    public Payment(double amount) {
        // Your code here
    }

    public double getAmount() {
        // Your code here
        return 0;
    }

    public String method() {
        // Your code here
        return "";
    }

    public double fee() {
        // Your code here
        return 0;
    }

    public double total() {
        // Your code here
        return 0;
    }

    public String receipt() {
        // Your code here
        return "";
    }
}
