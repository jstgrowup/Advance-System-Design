package com.chaicode.classesobjects;

/**
 * Starlight Cinema — MovieTicket
 *
 * <p>Starlight Cinema prints a {@code MovieTicket} object for every seat sold. Two people
 * watching the same show hold two DIFFERENT ticket objects — discounting or cancelling one
 * ticket must never touch the other.
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>movie — e.g. "Jawan"</li>
 *   <li>seat — e.g. "F12"</li>
 *   <li>price — ticket price in rupees, e.g. 250.0 (starts at the default value 0.0)</li>
 *   <li>cancelled — whether the ticket was cancelled (starts at the default value false)</li>
 * </ul>
 *
 * <p>Implement these methods:
 * <ul>
 *   <li>{@code applyDiscount(int percent)}: valid only when the ticket is NOT cancelled and
 *     percent is between 1 and 50 (inclusive). Then set
 *     {@code price = price - price * percent / 100.0}, rounded to 2 decimals with
 *     {@code Math.round(value * 100) / 100.0}, and return true. Otherwise change nothing and
 *     return false.</li>
 *   <li>{@code cancel()}: if the ticket is already cancelled, return 0.0. Otherwise set
 *     cancelled to true and return the refund = 80% of the current price, rounded to 2 decimals
 *     the same way. The price field itself stays unchanged.</li>
 *   <li>{@code describe()}: for an active ticket return exactly (price formatted with
 *     {@code String.format("%.2f", price)})
 *     <pre>Jawan | Seat: F12 | Rs. 250.00</pre>
 *     and for a cancelled ticket return exactly
 *     <pre>Jawan | Seat: F12 | CANCELLED</pre></li>
 * </ul>
 */
public class MovieTicket {

    String movie;
    String seat;
    double price;
    boolean cancelled;

    public boolean applyDiscount(int percent) {
        // Your code here
        return false;
    }

    public double cancel() {
        // Your code here
        return 0.0;
    }

    public String describe() {
        // Your code here
        return "";
    }
}
