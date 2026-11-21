package com.chaicode.inheritance;

/**
 * FleetGo Delivery Fleet — Vehicle
 *
 * <p>FleetGo delivers parcels across Pune using bikes and trucks. Every vehicle has a
 * registration number, a maximum load and a current load, and every vehicle can be loaded
 * and unloaded the same way. Write that common behaviour ONCE here in {@code Vehicle};
 * {@link Bike} and {@link Truck} inherit it with {@code extends} and only add what is
 * different about them.
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>registration — e.g. "MH12AB1234"</li>
 *   <li>maxLoadKg — the heaviest load this vehicle can carry</li>
 *   <li>currentLoadKg — kg currently loaded (starts at 0)</li>
 * </ul>
 *
 * <p>Implement:
 * <ul>
 *   <li>Constructor {@code Vehicle(String registration, int maxLoadKg)}: store both values.</li>
 *   <li>{@code getRegistration()}, {@code getMaxLoadKg()}, {@code getCurrentLoadKg()}: plain getters.</li>
 *   <li>{@code load(int kg)}: return false (and change nothing) if kg &lt;= 0 or if
 *     currentLoadKg + kg would exceed maxLoadKg. Otherwise add kg and return true.
 *     Filling up to exactly maxLoadKg is allowed.</li>
 *   <li>{@code unloadAll()}: set currentLoadKg back to 0.</li>
 *   <li>{@code wheels()}: a generic vehicle has 4 wheels.</li>
 *   <li>{@code describe()}: return exactly
 *     <pre>MH12AB1234 | Load: 30/100 kg</pre></li>
 * </ul>
 *
 * <p>Then complete {@link Bike} and {@link Truck} — see their Javadoc.
 */
public class Vehicle {

    protected String registration;
    protected int maxLoadKg;
    protected int currentLoadKg;

    public Vehicle(String registration, int maxLoadKg) {
        // Your code here
    }

    public String getRegistration() {
        // Your code here
        return "";
    }

    public int getMaxLoadKg() {
        // Your code here
        return 0;
    }

    public int getCurrentLoadKg() {
        // Your code here
        return 0;
    }

    public boolean load(int kg) {
        // Your code here
        return false;
    }

    public void unloadAll() {
        // Your code here
    }

    public int wheels() {
        // Your code here
        return 0;
    }

    public String describe() {
        // Your code here
        return "";
    }
}
