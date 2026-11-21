package com.chaicode.interfaces;

/**
 * ChaiHome Automation — SmartLight
 *
 * <p>A smart bulb is both {@link Switchable} and {@link Dimmable}.
 *
 * <p>Rules:
 * <ul>
 *   <li>Constructor {@code SmartLight(String name)}: store the name. A new light is OFF
 *     with brightness {@link Dimmable#MAX_LEVEL} (100).</li>
 *   <li>{@code turnOn()}: switch on. If the brightness is currently 0, reset it to
 *     {@link Dimmable#MAX_LEVEL} first.</li>
 *   <li>{@code turnOff()}: switch off (brightness is kept).</li>
 *   <li>{@code isOn()} / {@code getName()} / {@code getBrightness()}: return the state.</li>
 *   <li>{@code setBrightness(int level)}: store {@code Dimmable.clamp(level)}.
 *     If the stored brightness is 0, the light switches OFF. Setting a brightness never
 *     switches a light ON.</li>
 *   <li><b>Add</b> an override of the default method {@code status()} (it is not in this file yet).
 *     Return exactly
 *     <pre>Hall Light is ON at 60%</pre>
 *     when on, and
 *     <pre>Hall Light is OFF</pre>
 *     when off.</li>
 * </ul>
 */
public class SmartLight implements Switchable, Dimmable {

    private String name;
    private boolean on;
    private int brightness;

    public SmartLight(String name) {
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

    @Override
    public void setBrightness(int level) {
        // Your code here
    }

    @Override
    public int getBrightness() {
        // Your code here
        return 0;
    }
}
