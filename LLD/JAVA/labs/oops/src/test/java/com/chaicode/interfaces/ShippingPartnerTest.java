package com.chaicode.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Interfaces - ShopSwift Couriers")
class ShippingPartnerTest {

    private static ShippingPartner fixed(String name, double price) {
        return new ShippingPartner() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public double quote(double weightKg, double distanceKm) {
                return price;
            }
        };
    }

    @Nested
    @DisplayName("Courier quotes")
    class Quotes {

        @Test
        void blueDartChargesByWeightAndDistance() {
            ShippingPartner blueDart = new BlueDartPartner();
            assertEquals("BlueDart", blueDart.getName());
            assertEquals(67.5, blueDart.quote(0.5, 50), 0.001);
            assertEquals(365.0, blueDart.quote(5, 1000), 0.001);
        }

        @Test
        void indiaPostAddsLongDistanceSurcharge() {
            ShippingPartner indiaPost = new IndiaPostPartner();
            assertEquals("India Post", indiaPost.getName());
            assertEquals(80.0, indiaPost.quote(0.5, 50), 0.001);
            assertEquals(170.0, indiaPost.quote(5, 500), 0.001);
            assertEquals(230.0, indiaPost.quote(5, 1000), 0.001);
        }

        @Test
        void invalidParcelsThrow() {
            assertThrows(IllegalArgumentException.class, () -> new BlueDartPartner().quote(0, 10));
            assertThrows(IllegalArgumentException.class, () -> new BlueDartPartner().quote(2, -1));
            assertThrows(IllegalArgumentException.class, () -> new IndiaPostPartner().quote(-3, 10));
            assertThrows(IllegalArgumentException.class, () -> new IndiaPostPartner().quote(1, -5));
        }
    }

    @Nested
    @DisplayName("Default & private interface methods")
    class DefaultMethods {

        @Test
        void quoteWithGstComesFromTheInterface() {
            assertEquals(79.65, new BlueDartPartner().quoteWithGst(0.5, 50), 0.001);
            assertEquals(94.4, new IndiaPostPartner().quoteWithGst(0.5, 50), 0.001);
            assertEquals(271.4, new IndiaPostPartner().quoteWithGst(5, 1000), 0.001);
            assertThrows(NoSuchMethodException.class,
                    () -> BlueDartPartner.class.getDeclaredMethod("quoteWithGst", double.class, double.class));
        }

        @Test
        void gstIsRoundedToTwoDecimals() {
            assertEquals(12.12, fixed("Local", 10.27).quoteWithGst(1, 1), 0.0001);
        }

        @Test
        void privateRound2HelperLivesOnTheInterface() throws NoSuchMethodException {
            Method helper = ShippingPartner.class.getDeclaredMethod("round2", double.class);
            assertTrue(Modifier.isPrivate(helper.getModifiers()), "round2 must be private");
            assertEquals(double.class, helper.getReturnType());
        }
    }

    @Nested
    @DisplayName("ShippingPartner.cheapest()")
    class Cheapest {

        @Test
        void picksLowestQuote() {
            ShippingPartner blueDart = new BlueDartPartner();
            ShippingPartner indiaPost = new IndiaPostPartner();
            List<ShippingPartner> partners = List.of(indiaPost, blueDart);
            assertSame(blueDart, ShippingPartner.cheapest(partners, 0.5, 50));
            assertSame(indiaPost, ShippingPartner.cheapest(partners, 5, 1000));
        }

        @Test
        void tieGoesToFirstPartner() {
            ShippingPartner first = fixed("Delhivery", 99);
            ShippingPartner second = fixed("Ekart", 99);
            assertSame(first, ShippingPartner.cheapest(List.of(first, second), 1, 1));
        }

        @Test
        void emptyOrNullListThrows() {
            assertThrows(IllegalArgumentException.class, () -> ShippingPartner.cheapest(List.of(), 1, 1));
            assertThrows(IllegalArgumentException.class, () -> ShippingPartner.cheapest(null, 1, 1));
        }
    }
}
