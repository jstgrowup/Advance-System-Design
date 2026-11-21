package com.chaicode.accessmodifiers;

/**
 * ChaiCode Login — UserAccount
 *
 * <p>The ChaiCode platform stores one {@code UserAccount} per learner. Right now every field
 * is wide open — any class in the package could read the password! Lock it down with access
 * modifiers and expose only a safe public API.
 *
 * <p>Access rules (checked with reflection):
 * <ul>
 *   <li>Make ALL four instance fields (username, email, password, failedAttempts)
 *     {@code private}.</li>
 *   <li>The password must never leave the object: do NOT add a {@code getPassword()} method.
 *     The only way to use it is the public {@code checkPassword(...)}.</li>
 *   <li>Make the helper {@code isStrong(String)} {@code private} — it is an internal detail.</li>
 *   <li>Keep the getters, {@code checkPassword}, {@code changePassword} and
 *     {@code isLocked} {@code public}.</li>
 * </ul>
 *
 * <p>Behaviour:
 * <ul>
 *   <li>{@code isStrong(String candidate)}: true when candidate is non-null, has at least 8
 *     characters and contains at least one digit (0-9).</li>
 *   <li>Constructor {@code UserAccount(String username, String email, String password)}:
 *     validate in this order, throwing {@link IllegalArgumentException} on the first failure:
 *     username null or blank (after trim); email null or without '@'; password not strong
 *     (use {@code isStrong}). Store the TRIMMED username, the email and the password;
 *     failedAttempts starts at 0.</li>
 *   <li>{@code getUsername()}, {@code getEmail()}, {@code getFailedAttempts()}: return the
 *     field values.</li>
 *   <li>{@code isLocked()}: true when failedAttempts &gt;= {@link #MAX_ATTEMPTS}.</li>
 *   <li>{@code checkPassword(String attempt)}: if the account is locked return false (do not
 *     count it). If attempt equals the password, reset failedAttempts to 0 and return true.
 *     Otherwise (including null) increase failedAttempts by 1 and return false.</li>
 *   <li>{@code changePassword(String oldPassword, String newPassword)}: first verify
 *     oldPassword using {@code checkPassword} (so a wrong old password counts as a failed
 *     attempt) — if it fails return false. If newPassword is not strong return false and keep
 *     the old password. Otherwise store newPassword and return true.</li>
 * </ul>
 */
public class UserAccount {

    public static final int MAX_ATTEMPTS = 3;

    String username;
    String email;
    String password;
    int failedAttempts;

    public UserAccount(String username, String email, String password) {
        // Your code here
    }

    public String getUsername() {
        // Your code here
        return null;
    }

    public String getEmail() {
        // Your code here
        return null;
    }

    public int getFailedAttempts() {
        // Your code here
        return 0;
    }

    public boolean isLocked() {
        // Your code here
        return false;
    }

    public boolean checkPassword(String attempt) {
        // Your code here
        return false;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        // Your code here
        return false;
    }

    boolean isStrong(String candidate) {
        // Your code here
        return false;
    }
}
