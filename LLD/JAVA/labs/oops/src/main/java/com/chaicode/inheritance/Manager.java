package com.chaicode.inheritance;

/**
 * TechCorp HR — Manager
 *
 * <p>A Manager IS-A {@link Employee} who leads a team.
 *
 * <ul>
 *   <li>Field {@code teamSize} (already declared).</li>
 *   <li>Constructor {@code Manager(String name, double baseSalary, int teamSize)}: replace the
 *     placeholder {@code super(null, 0)} with {@code super(...)} passing name and baseSalary, then
 *     store teamSize. A negative teamSize throws {@code IllegalArgumentException}.</li>
 *   <li>{@code getTeamSize()}: plain getter.</li>
 *   <li>{@code monthlyPay()}: {@code @Override} it — call {@code super.monthlyPay()} (do not repeat the
 *     parent's formula) and add {@link #BONUS_PER_REPORT} for every team member.
 *     Example: base 60000, team of 4 → 60000 + 2000 + 4 * 1500 = 68000.</li>
 *   <li>{@code role()}: {@code @Override} to return {@code "Manager"}.</li>
 * </ul>
 */
public class Manager extends Employee {

    public static final double BONUS_PER_REPORT = 1500;

    int teamSize;

    public Manager(String name, double baseSalary, int teamSize) {
        super(null, 0);
        // Your code here
    }

    public int getTeamSize() {
        // Your code here
        return 0;
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
