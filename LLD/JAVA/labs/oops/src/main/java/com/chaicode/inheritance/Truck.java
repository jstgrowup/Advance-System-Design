package com.chaicode.inheritance;

/**
 * FleetGo Delivery Fleet — Truck
 *
 * <p>A truck IS-A {@link Vehicle}, but its capacity depends on how many axles it has.
 *
 * <ul>
 *   <li>Field {@code axles} (already declared).</li>
 *   <li>Constructor {@code Truck(String registration, int axles)}: max load is
 *     {@code axles * }{@link #KG_PER_AXLE} kg. Replace the placeholder {@code super(null, 0)}
 *     with the correct {@code super(...)} call, then store axles.</li>
 *   <li>{@code getAxles()}: plain getter.</li>
 *   <li>{@code wheels()}: override — every axle carries 4 wheels ({@code axles * 4}).</li>
 *   <li>{@code describe()}: override and REUSE {@code super.describe()}:
 *     <pre>Truck | KA01TR9999 | Load: 0/10000 kg | Axles: 2</pre></li>
 * </ul>
 */
public class Truck extends Vehicle {

    public static final int KG_PER_AXLE = 5000;

    int axles;

    public Truck(String registration, int axles) {
        super(null, 0);
        // Your code here
    }

    public int getAxles() {
        // Your code here
        return 0;
    }

    @Override
    public int wheels() {
        // Your code here
        return 0;
    }

    @Override
    public String describe() {
        // Your code here
        return "";
    }
}
