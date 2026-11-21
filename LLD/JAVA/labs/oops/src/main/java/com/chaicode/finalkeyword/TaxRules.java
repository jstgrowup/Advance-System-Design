package com.chaicode.finalkeyword;

/**
 * KiranaKart GST Calculator — TaxRules
 *
 * <p>KiranaKart bills every item with GST. The GST slabs are fixed by law, so they must be
 * true constants: nobody in the codebase should be able to write
 * {@code TaxRules.GST_LUXURY = 0;}.
 *
 * <p>Constants (already declared with the right values):
 * <ul>
 *   <li><b>Make every constant {@code public static final}</b> — add the missing
 *     {@code final} (checked with reflection).</li>
 * </ul>
 * <pre>GST_EXEMPT    = 0   (category "EXEMPT",    e.g. fresh milk)
 * GST_ESSENTIAL = 5   (category "ESSENTIAL", e.g. packaged atta)
 * GST_STANDARD  = 18  (category "STANDARD",  e.g. biscuits, soap)
 * GST_LUXURY    = 28  (category "LUXURY",    e.g. aerated drinks)</pre>
 *
 * <p>Implement (always use the constants, never repeat the numbers):
 * <ul>
 *   <li>{@code rateFor(String category)}: return the GST percent for the category. Match
 *     ignoring case and surrounding spaces. Null or unknown category: throw
 *     {@code IllegalArgumentException}.</li>
 *   <li>{@code gstAmount(double price, String category)}: {@code price * rate / 100}, rounded
 *     to 2 decimals ({@code Math.round(value * 100) / 100.0}). Negative price: throw
 *     {@code IllegalArgumentException}.</li>
 *   <li>{@code totalWithGst(double price, String category)}: {@code price + gstAmount(...)},
 *     rounded to 2 decimals.</li>
 *   <li>{@code splitCgstSgst(double price, String category)}: inside one state GST is split
 *     equally into CGST and SGST. Each half is {@code gstAmount(...) / 2}, printed with
 *     {@code String.format("%.2f", half)}:
 *     <pre>CGST: 9.00 | SGST: 9.00</pre></li>
 * </ul>
 */
public class TaxRules {

    public static int GST_EXEMPT = 0;
    public static int GST_ESSENTIAL = 5;
    public static int GST_STANDARD = 18;
    public static int GST_LUXURY = 28;

    private TaxRules() {
    }

    public static int rateFor(String category) {
        // Your code here
        return 0;
    }

    public static double gstAmount(double price, String category) {
        // Your code here
        return 0.0;
    }

    public static double totalWithGst(double price, String category) {
        // Your code here
        return 0.0;
    }

    public static String splitCgstSgst(double price, String category) {
        // Your code here
        return "";
    }
}
