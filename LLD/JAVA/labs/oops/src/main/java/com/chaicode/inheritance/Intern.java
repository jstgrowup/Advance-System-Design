package com.chaicode.inheritance;

/**
 * TechCorp HR — Intern
 *
 * <p>An Intern IS-A {@link Employee}, but interns are paid a fixed stipend with no allowance.
 *
 * <ul>
 *   <li>Constructor {@code Intern(String name, double stipend)}: replace the placeholder
 *     {@code super(null, 0)} with {@code super(...)} — the stipend is stored as the base salary.</li>
 *   <li>{@code monthlyPay()}: {@code @Override} to return ONLY the stipend (the base salary) —
 *     here the child replaces the parent's rule instead of extending it.</li>
 *   <li>{@code role()}: {@code @Override} to return {@code "Intern"}.</li>
 * </ul>
 */
public class Intern extends Employee {

    public Intern(String name, double stipend) {
        super(null, 0);
        // Your code here
    }

    @Override
    public double monthlyPay() {
        // Your code here
        return 0;
    }

    @Override
    public String role() {
        // Your code here
        return "";
    }
}
