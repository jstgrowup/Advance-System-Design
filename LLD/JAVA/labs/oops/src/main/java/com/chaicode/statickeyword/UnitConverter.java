package com.chaicode.statickeyword;

/**
 * ChaiKitchen Recipe Converter — UnitConverter
 *
 * <p>ChaiKitchen imports recipes from foreign food blogs that use cups, teaspoons and
 * Fahrenheit. {@code UnitConverter} is a pure utility class: it holds no object state, so
 * every method is {@code static} and is called like {@code UnitConverter.cupsToMl(2)}.
 *
 * <p>Utility-class rules (checked with reflection):
 * <ul>
 *   <li>Add a <b>private</b> no-argument constructor so nobody can write
 *     {@code new UnitConverter()}. It must be the only constructor.</li>
 *   <li>Every public method must be {@code static} (they already are — keep them that way).</li>
 * </ul>
 *
 * <p>Rounding: unless stated otherwise, round results to 1 decimal place using
 * {@code Math.round(value * 10) / 10.0}.
 *
 * <p>Implement:
 * <ul>
 *   <li>{@code cupsToMl(double cups)}: 1 cup = {@link #ML_PER_CUP} ml. Round to 1 decimal.
 *     Negative cups: throw {@code IllegalArgumentException}.</li>
 *   <li>{@code tspToGrams(double tsp, String ingredient)}: grams per teaspoon depend on the
 *     ingredient (match ignoring case and surrounding spaces):
 *     <pre>sugar -&gt; 4.2 g
 * salt  -&gt; 6.0 g
 * tea   -&gt; 2.5 g</pre>
 *     Round to 1 decimal. Throw {@code IllegalArgumentException} for negative tsp, a null
 *     ingredient or any other ingredient.</li>
 *   <li>{@code fahrenheitToCelsius(double f)}: C = (F - 32) * 5 / 9, rounded to 1 decimal.
 *     Below absolute zero ({@code f < -459.67}) throw {@code IllegalArgumentException}.</li>
 *   <li>{@code scale(double amount, int fromServings, int toServings)}: resize a recipe
 *     quantity: {@code amount * toServings / fromServings}, rounded to <b>2</b> decimals
 *     ({@code Math.round(value * 100) / 100.0}). Throw {@code IllegalArgumentException} if
 *     amount is negative or either servings value is &lt;= 0.</li>
 * </ul>
 */
public class UnitConverter {

    public static final double ML_PER_CUP = 240.0;

    public static double cupsToMl(double cups) {
        // Your code here
        return 0.0;
    }

    public static double tspToGrams(double tsp, String ingredient) {
        // Your code here
        return 0.0;
    }

    public static double fahrenheitToCelsius(double f) {
        // Your code here
        return 0.0;
    }

    public static double scale(double amount, int fromServings, int toServings) {
        // Your code here
        return 0.0;
    }
}
