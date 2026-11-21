package com.chaicode.finalkeyword;

import java.util.ArrayList;
import java.util.List;

/**
 * ChaiRides GPS — GpsLocation
 *
 * <p>A pickup point shared between the rider app and the driver app must never change
 * behind anyone's back. So a {@code GpsLocation} is fixed once it is created: "moving" it
 * gives you a brand-new location object and leaves the old one untouched.
 *
 * <p>Fields:
 * <ul>
 *   <li>{@code latitude}, {@code longitude} — <b>make both {@code private final}</b>
 *     (checked with reflection). A {@code final} field must be assigned exactly once, in the
 *     constructor, and can never be reassigned afterwards. Do not add setters.</li>
 *   <li>{@code landmarks} — already {@code private final}. {@code final} on a reference
 *     only means the field can never point to a DIFFERENT list
 *     ({@code landmarks = new ArrayList<>()} will not compile); the list object itself is
 *     still mutable, so {@code landmarks.add("Gate 2")} is perfectly legal.</li>
 * </ul>
 *
 * <p>Implement:
 * <ul>
 *   <li>Constructor {@code GpsLocation(double latitude, double longitude)}: latitude must be
 *     within -90..90 and longitude within -180..180 (both ends allowed). Otherwise — including
 *     {@code NaN} — throw {@code IllegalArgumentException}.
 *     Tip: {@code !(lat >= -90 && lat <= 90)} also catches NaN.</li>
 *   <li>{@code getLatitude()}, {@code getLongitude()}.</li>
 *   <li>{@code moveBy(double dLat, double dLon)}: return a NEW {@code GpsLocation} at
 *     {@code (latitude + dLat, longitude + dLon)}, each rounded to 6 decimals
 *     ({@code Math.round(value * 1_000_000) / 1_000_000.0}). The original object must not
 *     change. If the new point is out of range, the constructor's exception is thrown
 *     (no wrapping around the globe).</li>
 *   <li>{@code format()}: 4 decimals of the ABSOLUTE values with N/S and E/W
 *     (negative latitude = S, negative longitude = W; zero counts as N / E):
 *     <pre>28.6139 N, 77.2090 E
 * 33.8688 S, 151.2093 E
 * 40.7128 N, 74.0060 W</pre>
 *     Use {@code String.format("%.4f %s, %.4f %s", ...)}.</li>
 *   <li>{@code addLandmark(String name)}: add the trimmed name to {@code landmarks}; null or
 *     blank throws {@code IllegalArgumentException}.</li>
 *   <li>{@code getLandmarks()}: return an unmodifiable copy ({@code List.copyOf(landmarks)}),
 *     so callers cannot change our list. A location returned by {@code moveBy} starts with no
 *     landmarks.</li>
 * </ul>
 */
public class GpsLocation {

    double latitude;
    double longitude;
    private final List<String> landmarks = new ArrayList<>();

    public GpsLocation(double latitude, double longitude) {
        // Your code here
    }

    public double getLatitude() {
        // Your code here
        return 0.0;
    }

    public double getLongitude() {
        // Your code here
        return 0.0;
    }

    public GpsLocation moveBy(double dLat, double dLon) {
        // Your code here
        return null;
    }

    public String format() {
        // Your code here
        return "";
    }

    public void addLandmark(String name) {
        // Your code here
    }

    public List<String> getLandmarks() {
        // Your code here
        return null;
    }
}
