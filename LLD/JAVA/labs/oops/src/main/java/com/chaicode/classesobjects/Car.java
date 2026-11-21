package com.chaicode.classesobjects;

/**
 * ChaiRides Fleet — Car
 *
 * <p>ChaiRides is launching a small car-rental service. Every car in the fleet is
 * created from this single {@code Car} blueprint, but each car object keeps its
 * OWN state (brand, color, fuel).
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>brand — e.g. "Tata"</li>
 *   <li>color — e.g. "Red"</li>
 *   <li>fuelLevel — litres currently in the tank (starts at the default value 0)</li>
 * </ul>
 *
 * <p>Implement these methods:
 * <ul>
 *   <li>{@code refuel(int litres)}: add litres to fuelLevel. The tank holds at most
 *     {@link #TANK_CAPACITY} litres — never go above it. Ignore litres &lt;= 0.</li>
 *   <li>{@code drive(int km)}: every 10 km uses 1 litre (use km / 10, integer division).
 *     If there is enough fuel, subtract it and return true. If there is NOT enough fuel,
 *     do not change fuelLevel and return false. Ignore km &lt;= 0 (return false).</li>
 *   <li>{@code describe()}: return exactly
 *     <pre>Red Tata | Fuel: 12L</pre></li>
 * </ul>
 */
public class Car {

    public static final int TANK_CAPACITY = 40;

    String brand;
    String color;
    int fuelLevel;

    public void refuel(int litres) {
        // Your code here
    }

    public boolean drive(int km) {
        // Your code here
        return false;
    }

    public String describe() {
        // Your code here
        return "";
    }
}
