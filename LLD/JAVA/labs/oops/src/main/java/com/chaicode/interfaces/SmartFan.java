package com.chaicode.interfaces;

/**
 * ChaiHome Automation — SmartFan
 *
 * <p>A ceiling fan is only {@link Switchable} (no dimming).
 *
 * <p>Rules:
 * <ul>
 *   <li>Constructor {@code SmartFan(String name)}: store the name. A new fan is OFF.</li>
 *   <li>{@code turnOn()} / {@code turnOff()} / {@code isOn()} / {@code getName()}: the usual.</li>
 *   <li>Do NOT override {@code status()} — the fan must use the interface's default method.</li>
 * </ul>
 */
public class SmartFan implements Switchable {

    private String name;
    private boolean on;

    public SmartFan(String name) {
        // Your code here
    }

    @Override
    public void turnOn() {
        // Your code here
    }

    @Override
    public void turnOff() {
        // Your code here
    }

    @Override
    public boolean isOn() {
        // Your code here
        return false;
    }

    @Override
    public String getName() {
        // Your code here
        return "";
    }
}
