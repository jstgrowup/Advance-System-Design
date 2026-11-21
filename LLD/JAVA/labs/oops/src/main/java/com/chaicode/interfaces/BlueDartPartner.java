package com.chaicode.interfaces;

/**
 * ShopSwift Couriers — BlueDartPartner
 *
 * <p>BlueDart is fast and charges by weight AND distance.
 *
 * <p>Rules:
 * <ul>
 *   <li>{@code getName()} returns exactly {@code "BlueDart"}.</li>
 *   <li>{@code quote(weightKg, distanceKm)}: if {@code weightKg <= 0} or {@code distanceKm < 0},
 *     throw {@link IllegalArgumentException}. Otherwise return
 *     <pre>40 + 45 * weightKg + 0.1 * distanceKm</pre>
 *     Example: {@code quote(0.5, 50) = 67.5}.</li>
 *   <li>Do NOT override {@code quoteWithGst} — the interface's default method is enough.</li>
 * </ul>
 */
public class BlueDartPartner implements ShippingPartner {

    @Override
    public String getName() {
        // Your code here
        return "";
    }

    @Override
    public double quote(double weightKg, double distanceKm) {
        // Your code here
        return 0;
    }
}
