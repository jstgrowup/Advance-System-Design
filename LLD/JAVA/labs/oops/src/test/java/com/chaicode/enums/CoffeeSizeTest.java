package com.chaicode.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Enums - Bean & Brew Coffee Sizes")
class CoffeeSizeTest {

    @Nested
    @DisplayName("Constants with data")
    class ConstantsWithData {

        @Test
        void valuesAreInMenuOrderWithTheirMl() {
            CoffeeSize[] sizes = CoffeeSize.values();
            assertArrayEquals(new CoffeeSize[]{CoffeeSize.SMALL, CoffeeSize.MEDIUM, CoffeeSize.LARGE}, sizes);
            assertEquals(250, sizes[0].getMl());
            assertEquals(350, sizes[1].getMl());
            assertEquals(450, sizes[2].getMl());
        }

        @Test
        void gettersReturnConstructorData() {
            assertEquals("S", CoffeeSize.SMALL.getCode());
            assertEquals("L", CoffeeSize.LARGE.getCode());
            assertEquals(120, CoffeeSize.SMALL.getPrice());
            assertEquals(160, CoffeeSize.MEDIUM.getPrice());
            assertEquals(200, CoffeeSize.LARGE.getPrice());
        }

        @Test
        void instanceFieldsArePrivateFinal() {
            int checked = 0;
            for (Field field : CoffeeSize.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) continue;
                assertTrue(Modifier.isPrivate(field.getModifiers()), field.getName() + " must be private");
                assertTrue(Modifier.isFinal(field.getModifiers()), field.getName() + " must be final");
                checked++;
            }
            assertEquals(3, checked);
        }
    }

    @Nested
    @DisplayName("Enum methods")
    class Methods {

        @Test
        void priceForCups() {
            assertEquals(480, CoffeeSize.MEDIUM.priceFor(3));
            assertEquals(200, CoffeeSize.LARGE.priceFor(1));
            assertThrows(IllegalArgumentException.class, () -> CoffeeSize.SMALL.priceFor(0));
            assertThrows(IllegalArgumentException.class, () -> CoffeeSize.SMALL.priceFor(-2));
        }

        @Test
        void pricePerMlRoundedToTwoDecimals() {
            assertEquals(0.48, CoffeeSize.SMALL.pricePerMl(), 0.0001);
            assertEquals(0.46, CoffeeSize.MEDIUM.pricePerMl(), 0.0001);
            assertEquals(0.44, CoffeeSize.LARGE.pricePerMl(), 0.0001);
        }

        @Test
        void upgradeMovesToNextSize() {
            assertSame(CoffeeSize.MEDIUM, CoffeeSize.SMALL.upgrade());
            assertSame(CoffeeSize.LARGE, CoffeeSize.MEDIUM.upgrade());
            assertSame(CoffeeSize.LARGE, CoffeeSize.LARGE.upgrade());
        }

        @Test
        void labelUsesOrdinalAndName() {
            assertEquals("#1 SMALL - 250ml - ₹120", CoffeeSize.SMALL.label());
            assertEquals("#2 MEDIUM - 350ml - ₹160", CoffeeSize.MEDIUM.label());
            assertEquals("#3 LARGE - 450ml - ₹200", CoffeeSize.LARGE.label());
        }
    }

    @Nested
    @DisplayName("fromCode()")
    class FromCode {

        @Test
        void acceptsCodesAndNamesIgnoringCase() {
            assertSame(CoffeeSize.MEDIUM, CoffeeSize.fromCode("m"));
            assertSame(CoffeeSize.LARGE, CoffeeSize.fromCode(" L "));
            assertSame(CoffeeSize.SMALL, CoffeeSize.fromCode("small"));
            assertSame(CoffeeSize.MEDIUM, CoffeeSize.fromCode("Medium"));
        }

        @Test
        void unknownInputThrows() {
            assertThrows(IllegalArgumentException.class, () -> CoffeeSize.fromCode("XL"));
            assertThrows(IllegalArgumentException.class, () -> CoffeeSize.fromCode("medum"));
            assertThrows(IllegalArgumentException.class, () -> CoffeeSize.fromCode(""));
            assertThrows(IllegalArgumentException.class, () -> CoffeeSize.fromCode(null));
        }
    }
}
