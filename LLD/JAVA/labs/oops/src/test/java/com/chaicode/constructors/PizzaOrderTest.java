package com.chaicode.constructors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Constructors - Pizza Planet")
class PizzaOrderTest {

    @Nested
    @DisplayName("Overloaded constructors")
    class Overloads {

        @Test
        void sizeOnlyUsesDefaults() {
            PizzaOrder order = new PizzaOrder("SMALL");
            assertEquals("SMALL", order.size);
            assertEquals(0, order.toppings);
            assertFalse(order.extraCheese);
        }

        @Test
        void sizeAndToppings() {
            PizzaOrder order = new PizzaOrder("MEDIUM", 3);
            assertEquals("MEDIUM", order.size);
            assertEquals(3, order.toppings);
            assertFalse(order.extraCheese);
        }

        @Test
        void sizeToppingsAndCheese() {
            PizzaOrder order = new PizzaOrder("LARGE", 2, true);
            assertEquals("LARGE", order.size);
            assertEquals(2, order.toppings);
            assertTrue(order.extraCheese);
        }

        @Test
        void sizeIsCaseInsensitiveAndStoredUppercase() {
            assertEquals("MEDIUM", new PizzaOrder("medium").size);
            assertEquals("LARGE", new PizzaOrder("Large", 1).size);
            assertEquals("SMALL", new PizzaOrder("sMaLl", 0, true).size);
        }
    }

    @Nested
    @DisplayName("Validation")
    class Validation {

        @Test
        void invalidSizeThrowsInEveryConstructor() {
            assertThrows(IllegalArgumentException.class, () -> new PizzaOrder("XL"));
            assertThrows(IllegalArgumentException.class, () -> new PizzaOrder(null, 2));
            assertThrows(IllegalArgumentException.class, () -> new PizzaOrder("Regular", 1, true));
        }

        @Test
        void toppingsOutOfRangeThrow() {
            assertThrows(IllegalArgumentException.class, () -> new PizzaOrder("SMALL", -1));
            assertThrows(IllegalArgumentException.class, () -> new PizzaOrder("LARGE", 6, false));
            assertEquals(5, new PizzaOrder("LARGE", 5).toppings);
        }
    }

    @Test
    void priceIsComputedFromState() {
        assertEquals(199, new PizzaOrder("SMALL").price());
        assertEquals(419, new PizzaOrder("MEDIUM", 3).price());
        assertEquals(529, new PizzaOrder("LARGE", 2, true).price());
        assertEquals(249, new PizzaOrder("small", 0, true).price());
    }

    @Test
    void describe() {
        assertEquals("LARGE | 2 toppings | extra cheese | Rs. 529", new PizzaOrder("LARGE", 2, true).describe());
        assertEquals("SMALL | 0 toppings | no extra cheese | Rs. 199", new PizzaOrder("small").describe());
    }
}
