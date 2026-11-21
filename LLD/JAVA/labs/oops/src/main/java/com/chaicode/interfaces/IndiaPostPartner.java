package com.chaicode.interfaces;

/**
 * ShopSwift Couriers — IndiaPostPartner
 *
 * <p>India Post has a higher base fee but a cheap per-kg rate, plus a flat surcharge for
 * long-distance parcels.
 *
 * <p>Rules:
 * <ul>
 *   <li>{@code getName()} returns exactly {@code "India Post"}.</li>
 *   <li>{@code quote(weightKg, distanceKm)}: if {@code weightKg <= 0} or {@code distanceKm < 0},
 *     throw {@link IllegalArgumentException}. Otherwise return
 *     <pre>70 + 20 * weightKg</pre>
 *     plus a flat 60 when {@code distanceKm > 500} (exactly 500 km has no surcharge).
 *     Examples: {@code quote(0.5, 50) = 80.0}, {@code quote(5, 1000) = 230.0}.</li>
 *   <li>Do NOT override {@code quoteWithGst}.</li>
 * </ul>
 */
public class IndiaPostPartner implements ShippingPartner {

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
