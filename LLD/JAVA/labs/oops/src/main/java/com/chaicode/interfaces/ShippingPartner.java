package com.chaicode.interfaces;

import java.util.List;

/**
 * ShopSwift Couriers — ShippingPartner
 *
 * <p>ShopSwift ships parcels through several courier partners. Checkout only talks to this
 * interface, so a new courier can be plugged in without touching checkout code.
 * Implement {@link BlueDartPartner} and {@link IndiaPostPartner} too (read their Javadoc).
 *
 * <p>Already declared:
 * <ul>
 *   <li>Constant {@link #GST_RATE} = 0.18 (18%).</li>
 *   <li>Abstract {@code getName()} and {@code quote(double weightKg, double distanceKm)} —
 *     the courier's price in rupees BEFORE GST.</li>
 * </ul>
 *
 * <p>Implement:
 * <ol>
 *   <li><b>Add</b> a private interface helper method (it is not in this file yet):
 *     <pre>private double round2(double amount)</pre>
 *     returning {@code Math.round(amount * 100) / 100.0}.</li>
 *   <li>Default method {@code quoteWithGst(weightKg, distanceKm)}:
 *     {@code quote(weightKg, distanceKm) * (1 + GST_RATE)}, rounded with {@code round2}.
 *     Example: a quote of 67.5 becomes 79.65.</li>
 *   <li>Static factory {@code ShippingPartner.cheapest(partners, weightKg, distanceKm)}:
 *     return the partner with the lowest {@code quote(weightKg, distanceKm)}.
 *     On a tie, the partner that appears first in the list wins.
 *     If {@code partners} is {@code null} or empty, throw {@link IllegalArgumentException}.</li>
 * </ol>
 */
public interface ShippingPartner {

    double GST_RATE = 0.18;

    String getName();

    double quote(double weightKg, double distanceKm);

    default double quoteWithGst(double weightKg, double distanceKm) {
        // Your code here
        return 0;
    }

    static ShippingPartner cheapest(List<ShippingPartner> partners, double weightKg, double distanceKm) {
        // Your code here
        return null;
    }
}
