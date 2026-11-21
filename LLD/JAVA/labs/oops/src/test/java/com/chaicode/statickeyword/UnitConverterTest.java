package com.chaicode.statickeyword;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("static Keyword - ChaiKitchen Converter")
class UnitConverterTest {

    @Test
    void isAUtilityClass() {
        Constructor<?>[] constructors = UnitConverter.class.getDeclaredConstructors();
        assertEquals(1, constructors.length, "exactly one constructor expected");
        assertTrue(Modifier.isPrivate(constructors[0].getModifiers()), "constructor must be private");
        assertEquals(0, constructors[0].getParameterCount());
        for (Method m : UnitConverter.class.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers())) {
                assertTrue(Modifier.isStatic(m.getModifiers()), m.getName() + " must be static");
            }
        }
    }

    @Nested
    @DisplayName("cupsToMl()")
    class Cups {

        @Test
        void convertsAndRounds() {
            assertEquals(240.0, UnitConverter.cupsToMl(1));
            assertEquals(120.0, UnitConverter.cupsToMl(0.5));
            assertEquals(312.0, UnitConverter.cupsToMl(1.3));
            assertEquals(80.0, UnitConverter.cupsToMl(1.0 / 3));
        }

        @Test
        void rejectsNegative() {
            assertThrows(IllegalArgumentException.class, () -> UnitConverter.cupsToMl(-1));
        }
    }

    @Nested
    @DisplayName("tspToGrams()")
    class Teaspoons {

        @Test
        void usesIngredientDensityIgnoringCase() {
            assertEquals(8.4, UnitConverter.tspToGrams(2, "sugar"));
            assertEquals(9.0, UnitConverter.tspToGrams(1.5, " Salt "));
            assertEquals(7.5, UnitConverter.tspToGrams(3, "TEA"));
            assertEquals(1.1, UnitConverter.tspToGrams(0.25, "sugar"));
        }

        @Test
        void rejectsUnknownOrInvalid() {
            assertThrows(IllegalArgumentException.class, () -> UnitConverter.tspToGrams(1, "saffron"));
            assertThrows(IllegalArgumentException.class, () -> UnitConverter.tspToGrams(1, null));
            assertThrows(IllegalArgumentException.class, () -> UnitConverter.tspToGrams(-2, "salt"));
        }
    }

    @Nested
    @DisplayName("fahrenheitToCelsius()")
    class Temperature {

        @Test
        void convertsAndRounds() {
            assertEquals(100.0, UnitConverter.fahrenheitToCelsius(212));
            assertEquals(37.0, UnitConverter.fahrenheitToCelsius(98.6));
            assertEquals(176.7, UnitConverter.fahrenheitToCelsius(350));
            assertEquals(-40.0, UnitConverter.fahrenheitToCelsius(-40));
        }

        @Test
        void rejectsBelowAbsoluteZero() {
            assertThrows(IllegalArgumentException.class, () -> UnitConverter.fahrenheitToCelsius(-500));
        }
    }

    @Test
    void scaleResizesRecipe() {
        assertEquals(375.0, UnitConverter.scale(250, 4, 6));
        assertEquals(66.67, UnitConverter.scale(100, 3, 2));
        assertThrows(IllegalArgumentException.class, () -> UnitConverter.scale(100, 0, 2));
        assertThrows(IllegalArgumentException.class, () -> UnitConverter.scale(100, 2, -1));
        assertThrows(IllegalArgumentException.class, () -> UnitConverter.scale(-5, 2, 4));
    }
}
