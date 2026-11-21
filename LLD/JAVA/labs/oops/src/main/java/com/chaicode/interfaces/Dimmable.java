package com.chaicode.interfaces;

/**
 * ChaiHome Automation — Dimmable
 *
 * <p>A second, separate contract for devices whose brightness can be changed.
 * A class can implement MANY interfaces, so a light can be both {@link Switchable}
 * and {@code Dimmable}.
 *
 * <p>Interface constants (already declared — they are automatically
 * {@code public static final}):
 * <ul>
 *   <li>{@link #MIN_LEVEL} = 0</li>
 *   <li>{@link #MAX_LEVEL} = 100</li>
 * </ul>
 *
 * <p>Implement the <b>static</b> interface method:
 * <ul>
 *   <li>{@code Dimmable.clamp(int level)}: return {@link #MIN_LEVEL} if level is below it,
 *     {@link #MAX_LEVEL} if level is above it, otherwise level itself.
 *     Examples: {@code clamp(150) -> 100}, {@code clamp(-5) -> 0}, {@code clamp(40) -> 40}.
 *     Call it as {@code Dimmable.clamp(...)} — static interface methods are not inherited.</li>
 * </ul>
 */
public interface Dimmable {

    int MIN_LEVEL = 0;
    int MAX_LEVEL = 100;

    void setBrightness(int level);

    int getBrightness();

    static int clamp(int level) {
        // Your code here
        return 0;
    }
}
