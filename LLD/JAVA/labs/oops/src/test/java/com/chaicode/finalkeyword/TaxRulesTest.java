package com.chaicode.finalkeyword;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("final Keyword - KiranaKart GST")
class TaxRulesTest {

    @Test
    void slabsArePublicStaticFinalConstants() throws Exception {
        String[] names = {"GST_EXEMPT", "GST_ESSENTIAL", "GST_STANDARD", "GST_LUXURY"};
        int[] values = {0, 5, 18, 28};
        for (int i = 0; i < names.length; i++) {
            Field field = TaxRules.class.getDeclaredField(names[i]);
            int mods = field.getModifiers();
            assertTrue(Modifier.isPublic(mods), names[i] + " must be public");
            assertTrue(Modifier.isStatic(mods), names[i] + " must be static");
            assertTrue(Modifier.isFinal(mods), names[i] + " must be final");
            assertEquals(values[i], field.getInt(null), names[i]);
        }
    }

    @Nested
    @DisplayName("rateFor()")
    class RateFor {

        @Test
        void matchesCategoryIgnoringCase() {
            assertEquals(0, TaxRules.rateFor("exempt"));
            assertEquals(5, TaxRules.rateFor("Essential"));
            assertEquals(18, TaxRules.rateFor(" STANDARD "));
            assertEquals(28, TaxRules.rateFor("luxury"));
        }

        @Test
        void unknownCategoryThrows() {
            assertThrows(IllegalArgumentException.class, () -> TaxRules.rateFor("premium"));
            assertThrows(IllegalArgumentException.class, () -> TaxRules.rateFor(null));
        }
    }

    @Nested
    @DisplayName("GST amounts")
    class Amounts {

        @Test
        void gstAmountIsRoundedToPaise() {
            assertEquals(36.0, TaxRules.gstAmount(199.99, "STANDARD"));
            assertEquals(280.0, TaxRules.gstAmount(1000, "LUXURY"));
            assertEquals(2.25, TaxRules.gstAmount(45, "ESSENTIAL"));
            assertEquals(0.0, TaxRules.gstAmount(56, "EXEMPT"));
        }

        @Test
        void negativePriceThrows() {
            assertThrows(IllegalArgumentException.class, () -> TaxRules.gstAmount(-1, "STANDARD"));
            assertThrows(IllegalArgumentException.class, () -> TaxRules.totalWithGst(-10, "LUXURY"));
        }

        @Test
        void totalAddsGst() {
            assertEquals(235.99, TaxRules.totalWithGst(199.99, "STANDARD"));
            assertEquals(105.0, TaxRules.totalWithGst(100, "essential"));
            assertEquals(56.0, TaxRules.totalWithGst(56, "EXEMPT"));
        }
    }

    @Test
    void splitsIntoCgstAndSgst() {
        assertEquals("CGST: 9.00 | SGST: 9.00", TaxRules.splitCgstSgst(100, "STANDARD"));
        assertEquals("CGST: 6.25 | SGST: 6.25", TaxRules.splitCgstSgst(250, "ESSENTIAL"));
        assertEquals("CGST: 0.00 | SGST: 0.00", TaxRules.splitCgstSgst(80, "EXEMPT"));
    }
}
