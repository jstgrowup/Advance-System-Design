package com.chaicode.statickeyword;

import java.util.HashMap;
import java.util.Map;

/**
 * ChaiCode App Settings — AppConfig
 *
 * <p>The ChaiCode learning app keeps ONE set of settings for the whole program, so every
 * member of {@code AppConfig} is {@code static}: nobody ever creates an {@code AppConfig}
 * object. The defaults must be loaded by a <b>static block</b>, which runs automatically
 * when the class is first used.
 *
 * <p>Default settings (key -&gt; value):
 * <pre>app.name      -&gt; ChaiCode
 * app.theme     -&gt; dark
 * max.upload.mb -&gt; 25
 * app.version   -&gt; 2.4.1</pre>
 *
 * <p>Implement:
 * <ul>
 *   <li>The {@code static { ... }} block: put the defaults into {@code SETTINGS}.
 *     Tip: write a private static helper (e.g. {@code loadDefaults()}) and call it from both
 *     the static block and {@code reset()}.</li>
 *   <li>{@code get(String key)}: return the value. If the key is null or unknown, throw
 *     {@code IllegalArgumentException}.</li>
 *   <li>{@code getOrDefault(String key, String fallback)}: return the value, or
 *     {@code fallback} when the key is null or unknown (never throws).</li>
 *   <li>{@code getInt(String key)}: return the value parsed as an int. Unknown key or a value
 *     that is not a whole number: throw {@code IllegalArgumentException}
 *     (note: {@code NumberFormatException} already is one).</li>
 *   <li>{@code set(String key, String value)}: add or replace a setting. Null/blank key or
 *     null value: throw {@code IllegalArgumentException}.</li>
 *   <li>{@code reset()}: remove everything and load the defaults again (used by tests).</li>
 *   <li>{@code currentVersion()}: return a new {@link Version} parsed from the
 *     {@code app.version} setting.</li>
 * </ul>
 *
 * <p>{@link Version} is a <b>static nested class</b> — it does not need an {@code AppConfig}
 * object, so it is created with {@code new AppConfig.Version("2.4.1")}.
 * <ul>
 *   <li>Constructor: the text must be exactly three non-negative whole numbers separated by
 *     dots ({@code "major.minor.patch"}). Anything else (null, "2.4", "2.x.1", "1.-2.3",
 *     "1.2.3.4") throws {@code IllegalArgumentException}.</li>
 *   <li>{@code getMajor()}, {@code getMinor()}, {@code getPatch()}.</li>
 *   <li>{@code compareTo(Version other)}: compare major, then minor, then patch NUMERICALLY
 *     (so 2.10.0 is newer than 2.9.9). Return a negative number, 0, or a positive number.</li>
 *   <li>{@code isNewerThan(Version other)}: true if this version compares greater.</li>
 *   <li>{@code toString()}: {@code "v"} + the three numbers, e.g.
 *     <pre>v2.4.1</pre></li>
 * </ul>
 */
public class AppConfig {

    private static final Map<String, String> SETTINGS = new HashMap<>();

    static {
        // Your code here
    }

    private AppConfig() {
    }

    public static String get(String key) {
        // Your code here
        return null;
    }

    public static String getOrDefault(String key, String fallback) {
        // Your code here
        return null;
    }

    public static int getInt(String key) {
        // Your code here
        return 0;
    }

    public static void set(String key, String value) {
        // Your code here
    }

    public static void reset() {
        // Your code here
    }

    public static Version currentVersion() {
        // Your code here
        return null;
    }

    public static class Version implements Comparable<Version> {

        private int major;
        private int minor;
        private int patch;

        public Version(String text) {
            // Your code here
        }

        public int getMajor() {
            // Your code here
            return 0;
        }

        public int getMinor() {
            // Your code here
            return 0;
        }

        public int getPatch() {
            // Your code here
            return 0;
        }

        @Override
        public int compareTo(Version other) {
            // Your code here
            return 0;
        }

        public boolean isNewerThan(Version other) {
            // Your code here
            return false;
        }

        @Override
        public String toString() {
            // Your code here
            return "";
        }
    }
}
