package com.chaicode.constructors;

/**
 * FitZone Gym — GymMembership
 *
 * <p>FitZone Gym signs up a member exactly ONCE — that is the constructor's job, and it runs
 * automatically with {@code new}. After that the same membership object is renewed again and
 * again — that is a METHOD's job, called as many times as needed. The constructor also
 * works out the derived fields (months and fee) from the chosen plan, so nobody has to set
 * them by hand.
 *
 * <p>Plans:
 * <pre>
 * Plan       Months  Fee (Rs.)
 * MONTHLY    1       1500
 * QUARTERLY  3       4000
 * YEARLY     12      12000
 * </pre>
 *
 * <p>Fields (already declared — do not rename them): memberName, plan, monthsRemaining,
 * totalFeePaid, renewals.
 *
 * <p>Constructor {@code GymMembership(String memberName, String plan)}:
 * <ol>
 *   <li>memberName null or blank (after trim) → throw {@link IllegalArgumentException}.</li>
 *   <li>plan null or not one of the plans above (ignoring case) → throw
 *     {@link IllegalArgumentException}.</li>
 *   <li>Store the TRIMMED name and the plan in UPPERCASE.</li>
 *   <li>Derived fields: monthsRemaining = plan months, totalFeePaid = plan fee,
 *     renewals = 0.</li>
 * </ol>
 *
 * <p>Methods:
 * <ul>
 *   <li>{@code renew()}: loyal members get 10% off every renewal. charge = planFee * 90 / 100
 *     (integer arithmetic). Add the plan months to monthsRemaining, add charge to
 *     totalFeePaid, increase renewals by 1, and return charge.</li>
 *   <li>{@code completeMonth()}: if monthsRemaining &gt; 0, decrease it by 1 and return true;
 *     otherwise return false.</li>
 *   <li>{@code isActive()}: true when monthsRemaining &gt; 0.</li>
 *   <li>{@code describe()}: return exactly
 *     <pre>Rohit | QUARTERLY | 3 months left | Paid Rs. 4000 | Renewals: 0</pre>
 *     (the word "months" is always plural).</li>
 * </ul>
 */
public class GymMembership {

    String memberName;
    String plan;
    int monthsRemaining;
    int totalFeePaid;
    int renewals;

    public GymMembership(String memberName, String plan) {
        // Your code here
    }

    public int renew() {
        // Your code here
        return 0;
    }

    public boolean completeMonth() {
        // Your code here
        return false;
    }

    public boolean isActive() {
        // Your code here
        return false;
    }

    public String describe() {
        // Your code here
        return "";
    }
}
