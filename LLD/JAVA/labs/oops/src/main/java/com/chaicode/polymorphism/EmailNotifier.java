package com.chaicode.polymorphism;

/**
 * PingMe Notifications — EmailNotifier
 *
 * <p>Emails carry a sender address. Do NOT override any {@code send} method — only these:
 * <ul>
 *   <li>Constructor {@code EmailNotifier(String from)}: store the sender (field already declared).</li>
 *   <li>{@code channel()}: {@code "EMAIL"}.</li>
 *   <li>{@code format(String message)}: return exactly
 *     <pre>[EMAIL] From: noreply@pingme.in | Welcome</pre>
 *     (use {@code channel()} for the "EMAIL" part).</li>
 * </ul>
 */
public class EmailNotifier extends Notifier {

    String from;

    public EmailNotifier(String from) {
        // Your code here
    }

    @Override
    public String channel() {
        // Your code here
        return "";
    }

    @Override
    public String format(String message) {
        // Your code here
        return "";
    }
}
