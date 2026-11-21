package com.chaicode.records;

/**
 * WeatherWise Sensors — TemperatureReading
 *
 * <p>WeatherWise has rooftop sensors all over India sending one reading at a time.
 * A reading is pure data that must never change after it arrives — a perfect fit for a
 * {@code record}. The header (components {@code sensorId}, {@code city}, {@code celsius})
 * is already written.
 *
 * <p>Rules:
 * <ol>
 *   <li>Compact constructor:
 *     <ul>
 *       <li>{@code sensorId} or {@code city} {@code null} or blank → {@link IllegalArgumentException}.</li>
 *       <li>{@code celsius} outside {@link #MIN_CELSIUS}..{@link #MAX_CELSIUS} (-90.0 to 60.0,
 *         both inclusive) → {@link IllegalArgumentException}.</li>
 *       <li>Round {@code celsius} to 1 decimal: {@code Math.round(celsius * 10) / 10.0}
 *         (reassign the parameter). {@code 36.66} is stored as {@code 36.7}.</li>
 *     </ul></li>
 *   <li>{@code static fromFahrenheit(sensorId, city, fahrenheit)}: build a reading with
 *     {@code (fahrenheit - 32) * 5 / 9} celsius (the constructor does the rounding).
 *     {@code 104°F → 40.0}, {@code 98.6°F → 37.0}.</li>
 *   <li>{@code toFahrenheit()}: {@code celsius * 9 / 5 + 32}, rounded to 1 decimal the same way.
 *     {@code 36.6 → 97.9}.</li>
 *   <li>{@code isHeatwave()}: true when {@code celsius >= } {@link #HEATWAVE_CELSIUS} (40.0).</li>
 *   <li>{@code withCelsius(double newCelsius)}: records are immutable, so return a NEW reading
 *     with the same sensorId and city (all constructor rules still apply). The original
 *     reading must not change.</li>
 * </ol>
 */
public record TemperatureReading(String sensorId, String city, double celsius) {

    public static final double MIN_CELSIUS = -90.0;
    public static final double MAX_CELSIUS = 60.0;
    public static final double HEATWAVE_CELSIUS = 40.0;

    public TemperatureReading {
        // Your code here
    }

    public static TemperatureReading fromFahrenheit(String sensorId, String city, double fahrenheit) {
        // Your code here
        return null;
    }

    public double toFahrenheit() {
        // Your code here
        return 0;
    }

    public boolean isHeatwave() {
        // Your code here
        return false;
    }

    public TemperatureReading withCelsius(double newCelsius) {
        // Your code here
        return null;
    }
}
