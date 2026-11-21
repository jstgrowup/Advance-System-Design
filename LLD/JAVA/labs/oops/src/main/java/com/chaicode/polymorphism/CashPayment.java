package com.chaicode.polymorphism;

/**
 * ChaiKart Checkout — CashPayment
 *
 * <p>Cash on delivery costs extra for small orders.
 * <ul>
 *   <li>{@code method()}: {@code "CASH"}.</li>
 *   <li>{@code fee()}: {@link #COD_CHARGE} (20.0) when amount &lt; 500, otherwise 0.
 *     (500 exactly has no charge.)</li>
 * </ul>
 */
public class CashPayment extends Payment {

    public static final double COD_CHARGE = 20.0;

    public CashPayment(double amount) {
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
