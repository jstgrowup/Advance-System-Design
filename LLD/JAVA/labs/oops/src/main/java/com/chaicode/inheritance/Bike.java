package com.chaicode.inheritance;

/**
 * FleetGo Delivery Fleet — Bike
 *
 * <p>A delivery bike IS-A {@link Vehicle}. It inherits registration, load(), unloadAll() and
 * the getters — do NOT re-declare those fields or copy those methods here.
 *
 * <ul>
 *   <li>Constructor {@code Bike(String registration)}: every bike can carry at most
 *     {@link #MAX_LOAD_KG} kg. Replace the placeholder {@code super(null, 0)} with the correct
 *     {@code super(...)} call (it must stay the first statement).</li>
 *   <li>{@code wheels()}: override to return 2.</li>
 *   <li>{@code describe()}: override and REUSE the parent's text via {@code super.describe()}:
 *     <pre>Bike | MH12AB1234 | Load: 5/20 kg</pre></li>
 * </ul>
 */
public class Bike extends Vehicle {

    public static final int MAX_LOAD_KG = 20;

    public Bike(String registration) {
        super(null, 0);
        // Your code here
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
