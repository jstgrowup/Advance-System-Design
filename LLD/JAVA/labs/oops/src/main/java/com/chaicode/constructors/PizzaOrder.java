package com.chaicode.constructors;

/**
 * Pizza Planet — PizzaOrder
 *
 * <p>At Pizza Planet customers order in three different ways: "just a medium, please",
 * "a large with 2 toppings", or "a large with 2 toppings AND extra cheese". Instead of one
 * giant constructor, {@code PizzaOrder} offers three OVERLOADED constructors — same name,
 * different parameter lists.
 *
 * <p>Fields (already declared — do not rename them): size, toppings, extraCheese.
 *
 * <p>Constructors:
 * <ol>
 *   <li>{@code PizzaOrder(String size)}: toppings = 0, extraCheese = false.</li>
 *   <li>{@code PizzaOrder(String size, int toppings)}: extraCheese = false.</li>
 *   <li>{@code PizzaOrder(String size, int toppings, boolean extraCheese)}: sets everything.</li>
 * </ol>
 * Rules that apply to EVERY constructor (you may call one constructor from another
 * with {@code this(...)} or repeat the logic — your choice):
 * <ul>
 *   <li>size must be "SMALL", "MEDIUM" or "LARGE", ignoring case; store it in UPPERCASE
 *     (e.g. "medium" is stored as "MEDIUM"). A null or any other size throws
 *     {@link IllegalArgumentException}.</li>
 *   <li>toppings must be between 0 and 5 (inclusive), otherwise throw
 *     {@link IllegalArgumentException}.</li>
 * </ul>
 *
 * <p>Methods:
 * <ul>
 *   <li>{@code price()}: base price SMALL = 199, MEDIUM = 299, LARGE = 399, plus 40 per
 *     topping, plus 50 if extraCheese.</li>
 *   <li>{@code describe()}: return exactly (the word "toppings" is always plural)
 *     <pre>LARGE | 2 toppings | extra cheese | Rs. 529</pre>
 *     or, without cheese,
 *     <pre>SMALL | 0 toppings | no extra cheese | Rs. 199</pre></li>
 * </ul>
 */
public class PizzaOrder {

    String size;
    int toppings;
    boolean extraCheese;

    public PizzaOrder(String size) {
        // Your code here
    }

    public PizzaOrder(String size, int toppings) {
        // Your code here
    }

    public PizzaOrder(String size, int toppings, boolean extraCheese) {
        // Your code here
    }

    public int price() {
        // Your code here
        return 0;
    }

    public String describe() {
        // Your code here
        return "";
    }
}
