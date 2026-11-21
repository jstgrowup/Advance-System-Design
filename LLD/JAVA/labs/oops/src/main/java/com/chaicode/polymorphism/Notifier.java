package com.chaicode.polymorphism;

import java.util.List;

/**
 * PingMe Notifications — Notifier
 *
 * <p>PingMe sends alerts through the app, SMS and email. This challenge shows BOTH kinds of
 * polymorphism:
 * <ul>
 *   <li><b>Compile-time</b> (method overloading): three {@code send(...)} methods with the same name
 *     but different parameters — the compiler picks one based on the arguments.</li>
 *   <li><b>Runtime</b> (method overriding): {@link SmsNotifier} and {@link EmailNotifier} override
 *     {@code channel()} and {@code format(...)}; the object decides which version runs, even when
 *     called from inside the parent's {@code send(...)} methods.</li>
 * </ul>
 *
 * <p>Implement in {@code Notifier} (the parent, representing in-app notifications):
 * <ul>
 *   <li>{@code channel()}: return {@code "APP"}.</li>
 *   <li>{@code format(String message)}: return {@code "[" + channel() + "] " + message}, e.g.
 *     <pre>[APP] Hello</pre></li>
 *   <li>{@code send(String message)}: if message is null or blank ({@code isBlank()}) throw
 *     {@code IllegalArgumentException}; otherwise return {@code format(message)}.</li>
 *   <li>{@code send(String message, int priority)}: priority must be 1 to 5 (inclusive), otherwise throw
 *     {@code IllegalArgumentException}. Return {@code send(message)} followed by {@code " [P" + priority + "]"}:
 *     <pre>[APP] Server down [P5]</pre></li>
 *   <li>{@code send(String message, List<String> recipients)}: return a new list with one entry per
 *     recipient (same order): {@code recipient + " <- " + send(message)}, e.g.
 *     <pre>ravi &lt;- [APP] Hi</pre>
 *     An empty recipient list returns an empty list (but a blank message still throws).</li>
 * </ul>
 *
 * <p>Always build on {@code format(...)} / {@code send(message)} — never hard-code "[APP]" in the
 * overloads — so that the child classes work without overriding any {@code send} method.
 */
public class Notifier {

    public String channel() {
        // Your code here
        return "";
    }

    public String format(String message) {
        // Your code here
        return "";
    }

    public String send(String message) {
        // Your code here
        return "";
    }

    public String send(String message, int priority) {
        // Your code here
        return "";
    }

    public List<String> send(String message, List<String> recipients) {
        // Your code here
        return null;
    }
}
