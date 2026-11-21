package com.chaicode.abstraction;

/**
 * Zippy Delivery — DeliveryOrder
 *
 * <p>Zippy delivers both hot food and groceries. Every order has an id, an item total and a
 * distance, and every order's bill is calculated the SAME way — but the delivery fee depends on
 * what kind of order it is. So {@code DeliveryOrder} is {@code abstract}: it can never be created
 * directly, it defines WHAT every order must provide ({@code deliveryFee()}, {@code category()}),
 * and the children {@link FoodDelivery} and {@link GroceryDelivery} decide HOW.
 *
 * <p>The class and its two abstract methods are already declared — keep them abstract.
 * Fields {@code orderId}, {@code itemTotal}, {@code distanceKm} are already declared.
 *
 * <p>Implement the concrete parts:
 * <ul>
 *   <li>Constructor {@code DeliveryOrder(String orderId, double itemTotal, double distanceKm)}
 *     (an abstract class CAN have a constructor — children call it with {@code super(...)}).
 *     Throw {@code IllegalArgumentException} if itemTotal &lt;= 0 or distanceKm &lt; 0
 *     (0 km is allowed); otherwise store all three.</li>
 *   <li>{@code getOrderId()}, {@code getItemTotal()}, {@code getDistanceKm()}: plain getters.</li>
 *   <li>{@code platformFee()}: every order pays a flat {@link #PLATFORM_FEE} (5.0).</li>
 *   <li>{@code totalCost()}: {@code itemTotal + deliveryFee() + platformFee()} — the parent calls
 *     the abstract {@code deliveryFee()} without knowing which child will answer.</li>
 *   <li>{@code summary()}:
 *     <pre>String.format("%s [%s] items=%.2f delivery=%.2f total=%.2f", orderId, category(), itemTotal, deliveryFee(), totalCost())</pre>
 *     e.g. {@code Z-101 [FOOD] items=300.00 delivery=49.00 total=354.00}</li>
 * </ul>
 */
public abstract class DeliveryOrder {

    public static final double PLATFORM_FEE = 5.0;

    protected String orderId;
    protected double itemTotal;
    protected double distanceKm;

    public DeliveryOrder(String orderId, double itemTotal, double distanceKm) {
        // Your code here
    }

    public abstract double deliveryFee();

    public abstract String category();

    public String getOrderId() {
        // Your code here
        return "";
    }

    public double getItemTotal() {
        // Your code here
        return 0;
    }

    public double getDistanceKm() {
        // Your code here
        return 0;
    }

    public double platformFee() {
        // Your code here
        return 0;
    }

    public double totalCost() {
        // Your code here
        return 0;
    }

    public String summary() {
        // Your code here
        return "";
    }
}
