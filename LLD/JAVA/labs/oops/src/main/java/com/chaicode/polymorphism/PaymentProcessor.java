package com.chaicode.polymorphism;

import java.util.List;

/**
 * ChaiKart Checkout — PaymentProcessor
 *
 * <p>At the end of the day ChaiKart settles a mixed bag of payments. The processor must NOT check
 * the type of each payment ({@code instanceof} is not needed!) — it just calls the methods on the
 * {@link Payment} reference and lets each object answer for itself.
 *
 * <ul>
 *   <li>{@code totalCollected(List<Payment> payments)}: sum of {@code total()} of every payment
 *     (0 for an empty list).</li>
 *   <li>{@code totalFees(List<Payment> payments)}: sum of {@code fee()} of every payment.</li>
 *   <li>{@code receipts(List<Payment> payments)}: a new list with {@code receipt()} of every
 *     payment, in the same order.</li>
 * </ul>
 */
public class PaymentProcessor {

    public double totalCollected(List<Payment> payments) {
        // Your code here
        return 0;
    }

    public double totalFees(List<Payment> payments) {
        // Your code here
        return 0;
    }

    public List<String> receipts(List<Payment> payments) {
        // Your code here
        return null;
    }
}
