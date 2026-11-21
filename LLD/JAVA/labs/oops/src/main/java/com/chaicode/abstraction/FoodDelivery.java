package com.chaicode.abstraction;

/**
 * Zippy Delivery — FoodDelivery
 *
 * <p>Hot food is priced by distance, with a late-night surcharge.
 * <ul>
 *   <li>Constructor {@code FoodDelivery(String orderId, double itemTotal, double distanceKm, boolean lateNight)}:
 *     the {@code super(...)} call is already there; store lateNight (field already declared).</li>
 *   <li>{@code isLateNight()}: plain getter.</li>
 *   <li>{@code category()}: {@code "FOOD"}.</li>
 *   <li>{@code deliveryFee()}: {@link #BASE_FEE} (25) covers the first 2 km; every km beyond 2 costs
 *     {@link #PER_KM} (8), fractional km included. Add {@link #LATE_NIGHT_SURCHARGE} (30) if lateNight.
 *     <pre>
 * 1.5 km          25.0
 * 5 km            25 + 3 * 8        = 49.0
 * 3.5 km          25 + 1.5 * 8      = 37.0
 * 5 km late night 25 + 3 * 8 + 30   = 79.0
 *     </pre></li>
 * </ul>
 */
public class FoodDelivery extends DeliveryOrder {

    public static final double BASE_FEE = 25;
    public static final double PER_KM = 8;
    public static final double LATE_NIGHT_SURCHARGE = 30;

    boolean lateNight;

    public FoodDelivery(String orderId, double itemTotal, double distanceKm, boolean lateNight) {
        super(orderId, itemTotal, distanceKm);
        // Your code here
    }

    public boolean isLateNight() {
        // Your code here
        return false;
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
