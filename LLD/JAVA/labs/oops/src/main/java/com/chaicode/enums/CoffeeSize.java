package com.chaicode.enums;

/**
 * Bean &amp; Brew — CoffeeSize
 *
 * <p>Bean &amp; Brew's cup sizes used to be plain strings, and baristas kept typing "medum".
 * Now a cup size can only be one of a fixed set of enum constants, and each constant
 * carries its own data.
 *
 * <p>Constants (already declared, in this menu order):
 * <pre>
 * SMALL  ("S", 250 ml, ₹120)
 * MEDIUM ("M", 350 ml, ₹160)
 * LARGE  ("L", 450 ml, ₹200)
 * </pre>
 *
 * <p>Rules:
 * <ol>
 *   <li>Make the three instance fields {@code code}, {@code ml}, {@code price} <b>private</b> and
 *     <b>final</b>, and assign them in the constructor (enum constructors are implicitly private).</li>
 *   <li>{@code getCode()}, {@code getMl()}, {@code getPrice()}: return the fields.</li>
 *   <li>{@code priceFor(int cups)}: {@code price * cups}. If {@code cups <= 0} throw
 *     {@link IllegalArgumentException}.</li>
 *   <li>{@code pricePerMl()}: {@code price / ml} as a double, rounded to 2 decimals with
 *     {@code Math.round(value * 100) / 100.0}. Example: MEDIUM → 0.46.</li>
 *   <li>{@code upgrade()}: the next bigger size in {@code values()} order (use {@code ordinal()}).
 *     LARGE stays LARGE.</li>
 *   <li>{@code label()}: {@code "#" + (ordinal() + 1)}, then {@code name()}, ml and price, exactly
 *     <pre>#2 MEDIUM - 350ml - ₹160</pre></li>
 *   <li>{@code static fromCode(String input)}: find a size by its short code OR its full name,
 *     ignoring case and surrounding spaces: {@code "m"}, {@code " L "}, {@code "small"},
 *     {@code "Medium"} all work. Anything else (including {@code null} and blank) throws
 *     {@link IllegalArgumentException}. Tip: after checking the codes, {@code valueOf(...)}
 *     already throws {@code IllegalArgumentException} for unknown names.</li>
 * </ol>
 */
public enum CoffeeSize {

    SMALL("S", 250, 120),
    MEDIUM("M", 350, 160),
    LARGE("L", 450, 200);

    String code;
    int ml;
    int price;

    CoffeeSize(String code, int ml, int price) {
        // Your code here
    }

    public String getCode() {
        // Your code here
        return "";
    }

    public int getMl() {
        // Your code here
        return 0;
    }

    public int getPrice() {
        // Your code here
        return 0;
    }

    public int priceFor(int cups) {
        // Your code here
        return 0;
    }

    public double pricePerMl() {
        // Your code here
        return 0;
    }

    public CoffeeSize upgrade() {
        // Your code here
        return null;
    }

    public String label() {
        // Your code here
        return "";
    }

    public static CoffeeSize fromCode(String input) {
        // Your code here
        return null;
    }
}
