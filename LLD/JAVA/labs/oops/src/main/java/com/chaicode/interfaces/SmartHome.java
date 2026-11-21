package com.chaicode.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * ChaiHome Automation — SmartHome
 *
 * <p>ChaiHome's hub app controls every gadget in the flat. The hub does not care whether a
 * device is a light or a fan — it only talks to the {@link Switchable} contract
 * ("program to interfaces"). Finish {@link Switchable}, {@link Dimmable}, {@link SmartLight}
 * and {@link SmartFan} first (read their Javadoc), then this controller.
 *
 * <p>The hub keeps its devices in {@code devices} (already declared), in the order they were added.
 *
 * <p>Implement these methods:
 * <ul>
 *   <li>{@code addDevice(Switchable device)}: append the device. Ignore {@code null}.</li>
 *   <li>{@code turnAllOff()}: switch every device off.</li>
 *   <li>{@code countOn()}: how many devices are currently on.</li>
 *   <li>{@code statusReport()}: a new list with each device's {@code status()}, in the order
 *     the devices were added, e.g.
 *     <pre>[Hall Light is ON at 60%, Bedroom Fan is OFF]</pre></li>
 * </ul>
 */
public class SmartHome {

    private final List<Switchable> devices = new ArrayList<>();

    public void addDevice(Switchable device) {
        // Your code here
    }

    public void turnAllOff() {
        // Your code here
    }

    public int countOn() {
        // Your code here
        return 0;
    }

    public List<String> statusReport() {
        // Your code here
        return null;
    }
}
