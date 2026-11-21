package com.chaicode.records;

/**
 * ChaiPay Money — Money
 *
 * <p>ChaiPay never stores money as a {@code double} (₹0.1 + ₹0.2 is not ₹0.3 in floating point!).
 * Every amount is a whole number of paise plus a currency code, wrapped in a tiny immutable
 * {@code record}. The record header is already written, so Java already generates the
 * constructor, the accessors {@code paise()} / {@code currency()}, {@code equals()},
 * {@code hashCode()} and {@code toString()} for you.
 *
 * <p>Rules:
 * <ol>
 *   <li>Compact constructor (validate, then normalise), in this order:
 *     <ul>
 *       <li>{@code paise < 0} → {@link IllegalArgumentException}.</li>
 *       <li>{@code currency} must be exactly 3 letters A–Z in any case ({@code "inr"}, {@code "USD"});
 *         otherwise ({@code null}, {@code "RS"}, {@code "RUPEE"}, {@code "U5D"}) →
 *         {@link IllegalArgumentException}.</li>
 *       <li>Store the currency in UPPERCASE: reassign the {@code currency} parameter —
 *         the record copies it into the field for you.</li>
 *     </ul>
 *     So {@code new Money(1250, "inr")} equals {@code new Money(1250, "INR")}, and its
 *     {@code toString()} is
 *     <pre>Money[paise=1250, currency=INR]</pre></li>
 *   <li>{@code static ofRupees(double rupees)}: an INR Money with
 *     {@code Math.round(rupees * 100)} paise. {@code ofRupees(19.99)} → 1999 paise.</li>
 *   <li>{@code plus(Money other)}: a NEW Money with the paise added (this one is untouched).
 *     {@code null} or a different currency → {@link IllegalArgumentException}.</li>
 *   <li>{@code format()}: rupees and exactly two paise digits, no thousands separator.
 *     INR uses the ₹ symbol, every other currency uses its code and a space:
 *     <pre>
 * new Money(1250, "INR").format()   → ₹12.50
 * new Money(5, "INR").format()      → ₹0.05
 * new Money(1205, "USD").format()   → USD 12.05
 *     </pre></li>
 * </ol>
 */
public record Money(long paise, String currency) {

    public Money {
        // Your code here
    }

    public static Money ofRupees(double rupees) {
        // Your code here
        return null;
    }

    public Money plus(Money other) {
        // Your code here
        return null;
    }

    public String format() {
        // Your code here
        return "";
    }
}
