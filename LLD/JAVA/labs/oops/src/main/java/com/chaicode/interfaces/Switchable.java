package com.chaicode.interfaces;

/**
 * ChaiHome Automation — Switchable
 *
 * <p>The contract every ChaiHome device signs: "I can be switched on and off".
 * The interface says WHAT a device can do; each class decides HOW.
 *
 * <p>Abstract methods (already declared — implement them in the device classes):
 * <ul>
 *   <li>{@code turnOn()}, {@code turnOff()}, {@code isOn()}, {@code getName()}</li>
 * </ul>
 *
 * <p>Implement the <b>default</b> method:
 * <ul>
 *   <li>{@code status()}: built only from {@code getName()} and {@code isOn()}. Return exactly
 *     <pre>Bedroom Fan is ON</pre>
 *     or
 *     <pre>Bedroom Fan is OFF</pre></li>
 * </ul>
 * Every device gets this {@code status()} for free — a device may still override it
 * (see {@link SmartLight}).
 */
public interface Switchable {

    void turnOn();

    void turnOff();

    boolean isOn();

    String getName();

    default String status() {
        // Your code here
        return "";
    }
}
