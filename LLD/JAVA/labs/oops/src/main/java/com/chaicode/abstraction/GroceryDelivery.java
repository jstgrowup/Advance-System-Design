package com.chaicode.abstraction;

/**
 * Zippy Delivery — GroceryDelivery
 *
 * <p>Groceries ship free on big baskets, regardless of distance.
 * <ul>
 *   <li>{@code category()}: {@code "GROCERY"}.</li>
 *   <li>{@code deliveryFee()}: 0 when itemTotal &gt;= {@link #FREE_DELIVERY_ABOVE} (499),
 *     otherwise {@link #FLAT_FEE} (40).</li>
 * </ul>
 */
public class GroceryDelivery extends DeliveryOrder {

    public static final double FREE_DELIVERY_ABOVE = 499;
    public static final double FLAT_FEE = 40;

    public GroceryDelivery(String orderId, double itemTotal, double distanceKm) {
        super(orderId, itemTotal, distanceKm);
    }

    @Override
    public double deliveryFee() {
        // Your code here
        return 0;
    }

    @Override
    public String category() {
        // Your code here
        return "";
    }
}
