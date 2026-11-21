package com.chaicode.inheritance;

/**
 * TechCorp HR — Employee
 *
 * <p>TechCorp's HR portal pays everyone through ONE method: {@code monthlyPay()}. Regular
 * employees get their base salary plus an internet allowance. {@link Manager}s get everything
 * an employee gets PLUS a team bonus (so they build on the parent with {@code super.monthlyPay()}),
 * while {@link Intern}s replace the rule completely and get only their stipend.
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>name — e.g. "Ravi"</li>
 *   <li>baseSalary — monthly base salary in rupees</li>
 * </ul>
 *
 * <p>Implement:
 * <ul>
 *   <li>Constructor {@code Employee(String name, double baseSalary)}: store both values.</li>
 *   <li>{@code getName()}, {@code getBaseSalary()}: plain getters.</li>
 *   <li>{@code monthlyPay()}: {@code baseSalary + }{@link #INTERNET_ALLOWANCE}.</li>
 *   <li>{@code role()}: return {@code "Employee"}.</li>
 *   <li>{@code payslip()}: build the line by CALLING {@code role()} and {@code monthlyPay()} (so that
 *     subclasses automatically get the right payslip without overriding this method):
 *     <pre>String.format("%s %s: Rs. %.2f", role(), name, monthlyPay())</pre>
 *     e.g. {@code Employee Ravi: Rs. 42000.00}</li>
 * </ul>
 *
 * <p>Then complete {@link Manager} and {@link Intern} — see their Javadoc.
 */
public class Employee {

    public static final double INTERNET_ALLOWANCE = 2000;

    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        // Your code here
    }

    public String getName() {
        // Your code here
        return "";
    }

    public double getBaseSalary() {
        // Your code here
        return 0;
    }

    public double monthlyPay() {
        // Your code here
        return 0;
    }

    public String role() {
        // Your code here
        return "";
    }

    public String payslip() {
        // Your code here
        return "";
    }
}
