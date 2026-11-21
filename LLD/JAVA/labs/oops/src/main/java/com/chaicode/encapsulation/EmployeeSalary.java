package com.chaicode.encapsulation;

/**
 * TechCorp Payroll — EmployeeSalary
 *
 * <p>TechCorp's payroll system must never allow {@code emp.salary = 10000000;}. Salary is
 * READ-ONLY from outside and changes only through an approved raise. Each employee also sets
 * a 4-digit payroll PIN which is WRITE-ONLY: it can be set and verified, but never read back.
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>name — e.g. "Neha"</li>
 *   <li>salary — monthly salary in rupees</li>
 *   <li>pin — the payroll PIN (null until set)</li>
 * </ul>
 * Make ALL THREE fields {@code private}. Do NOT add {@code getPin()} or {@code setSalary(...)}.
 *
 * <p>Implement:
 * <ul>
 *   <li>Constructor {@code EmployeeSalary(String name, double salary)}: salary must be &gt; 0,
 *     otherwise throw {@code IllegalArgumentException}.</li>
 *   <li>{@code getName()} and {@code getSalary()}: plain getters.</li>
 *   <li>{@code raise(double percent)}: percent must be &gt; 0 and at most 30 (30 is allowed).
 *     Otherwise throw {@code IllegalArgumentException} and leave salary unchanged. A valid raise does
 *     {@code salary + salary * percent / 100}, rounded to 2 decimals:
 *     <pre>Math.round(newSalary * 100) / 100.0</pre>
 *     Example: 33333.33 with a 7% raise becomes 35666.66.</li>
 *   <li>{@code setPin(String pin)}: the PIN must be exactly 4 characters, all digits ('0'-'9').
 *     null or anything else throws {@code IllegalArgumentException}. Setting again replaces the old PIN.</li>
 *   <li>{@code verifyPin(String attempt)}: true only if a PIN has been set and it equals attempt;
 *     false otherwise (including when no PIN was ever set).</li>
 * </ul>
 */
public class EmployeeSalary {

    String name;
    double salary;
    String pin;

    public EmployeeSalary(String name, double salary) {
        // Your code here
    }

    public String getName() {
        // Your code here
        return "";
    }

    public double getSalary() {
        // Your code here
        return 0;
    }

    public void raise(double percent) {
        // Your code here
    }

    public void setPin(String pin) {
        // Your code here
    }

    public boolean verifyPin(String attempt) {
        // Your code here
        return false;
    }
}
