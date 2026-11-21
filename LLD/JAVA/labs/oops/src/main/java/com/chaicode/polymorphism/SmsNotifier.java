package com.chaicode.polymorphism;

/**
 * PingMe Notifications — SmsNotifier
 *
 * <p>SMS messages are short. Do NOT override any {@code send} method — only these two:
 * <ul>
 *   <li>{@code channel()}: {@code "SMS"}.</li>
 *   <li>{@code format(String message)}: if the message is longer than {@link #MAX_LENGTH} (20)
 *     characters, keep only its first 17 characters and append {@code "..."}; messages of 20 characters
 *     or fewer are kept as-is. Then reuse {@code super.format(...)} with the (possibly shortened) text:
 *     <pre>
 * "Hi there"                        [SMS] Hi there
 * "Your OTP is 482913 valid 5 min"  [SMS] Your OTP is 48291...
 *     </pre></li>
 * </ul>
 */
public class SmsNotifier extends Notifier {

    public static final int MAX_LENGTH = 20;

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
