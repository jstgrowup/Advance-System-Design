package com.chaicode.thiskeyword;

import java.util.ArrayList;
import java.util.List;

/**
 * ChaiMail — EmailBuilder
 *
 * <p>ChaiMail lets developers write emails in one smooth chain:
 * <pre>
 * String mail = new EmailBuilder()
 *         .to("riya@chaicode.com")
 *         .cc("aman@chaicode.com")
 *         .subject("Cohort starts Monday")
 *         .body("See you at 9 PM!")
 *         .build();
 * </pre>
 * The chain works because every setter-style method returns {@code this} — the SAME builder
 * object — so the next call continues on it. Each parameter has the same name as its field,
 * so use {@code this.field = parameter}.
 *
 * <p>Methods:
 * <ul>
 *   <li>{@code to(String to)}: a valid address is non-null and contains '@', otherwise throw
 *     {@link IllegalArgumentException}. Store it (calling {@code to} again replaces the
 *     recipient) and return {@code this}.</li>
 *   <li>{@code cc(String cc)}: same validation as {@code to}. Append it to ccList (keep the
 *     order they were added) and return {@code this}.</li>
 *   <li>{@code subject(String subject)}: store it and return {@code this}.</li>
 *   <li>{@code body(String body)}: store it and return {@code this}.</li>
 *   <li>{@code build()}: if no recipient was set, throw {@link IllegalStateException}.
 *     Otherwise return the lines below joined with {@code "\n"} (no trailing newline):
 *     <pre>
 * To: riya@chaicode.com
 * Cc: aman@chaicode.com, neha@chaicode.com
 * Subject: Cohort starts Monday
 *
 * See you at 9 PM!
 *     </pre>
 *     <ul>
 *       <li>The {@code Cc:} line lists all cc addresses separated by {@code ", "}; leave the
 *         whole line out when there are no cc addresses.</li>
 *       <li>If subject is null or blank, use {@code (no subject)}.</li>
 *       <li>Line after Subject is always an empty line; the last line is the body
 *         (an empty string if body is null).</li>
 *     </ul></li>
 * </ul>
 */
public class EmailBuilder {

    private String to;
    private String subject;
    private String body;
    private final List<String> ccList = new ArrayList<>();

    public EmailBuilder to(String to) {
        // Your code here
        return null;
    }

    public EmailBuilder cc(String cc) {
        // Your code here
        return null;
    }

    public EmailBuilder subject(String subject) {
        // Your code here
        return null;
    }

    public EmailBuilder body(String body) {
        // Your code here
        return null;
    }

    public String build() {
        // Your code here
        return "";
    }
}
