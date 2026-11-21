package com.chaicode.encapsulation;

/**
 * ChaiPay Wallet — DigitalWallet
 *
 * <p>ChaiPay is a tiny UPI-style wallet. The golden rule of any wallet: the balance can
 * only change through real money movements. There is NO "set balance" button — money
 * comes in via {@code deposit}, goes out via {@code withdraw}, and the wallet counts every
 * successful transaction.
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>ownerName — e.g. "Riya"</li>
 *   <li>balance — rupees in the wallet (starts at 0)</li>
 *   <li>transactionCount — number of SUCCESSFUL deposits + withdrawals (starts at 0)</li>
 * </ul>
 * Make ALL THREE fields {@code private}. Do NOT add a {@code setBalance} or
 * {@code setTransactionCount} method.
 *
 * <p>Implement:
 * <ul>
 *   <li>Constructor {@code DigitalWallet(String ownerName)}: store the owner; balance and count start at 0.</li>
 *   <li>{@code getOwnerName()}, {@code getBalance()}, {@code getTransactionCount()}: plain getters.</li>
 *   <li>{@code deposit(double amount)}: amount must be &gt; 0 and at most {@link #MAX_DEPOSIT}
 *     (10000 itself is allowed). Otherwise throw {@code IllegalArgumentException} and change nothing.
 *     A valid deposit adds to the balance and increments transactionCount.</li>
 *   <li>{@code withdraw(double amount)}:
 *     <ol>
 *       <li>amount &lt;= 0 → throw {@code IllegalArgumentException}.</li>
 *       <li>amount &gt; balance → return false; balance and transactionCount stay unchanged.</li>
 *       <li>otherwise subtract it, increment transactionCount and return true.</li>
 *     </ol></li>
 * </ul>
 */
public class DigitalWallet {

    public static final double MAX_DEPOSIT = 10000;

    String ownerName;
    double balance;
    int transactionCount;

    public DigitalWallet(String ownerName) {
        // Your code here
    }

    public String getOwnerName() {
        // Your code here
        return "";
    }

    public double getBalance() {
        // Your code here
        return 0;
    }

    public int getTransactionCount() {
        // Your code here
        return 0;
    }

    public void deposit(double amount) {
        // Your code here
    }

    public boolean withdraw(double amount) {
        // Your code here
        return false;
    }
}
