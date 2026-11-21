package com.chaicode.finalkeyword;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("final Keyword - ChaiRides GPS")
class GpsLocationTest {

    @Test
    void coordinateFieldsArePrivateFinalWithNoSetters() throws Exception {
        for (String name : new String[] {"latitude", "longitude", "landmarks"}) {
            int mods = GpsLocation.class.getDeclaredField(name).getModifiers();
            assertTrue(Modifier.isPrivate(mods), name + " must be private");
            assertTrue(Modifier.isFinal(mods), name + " must be final");
        }
        for (Method m : GpsLocation.class.getDeclaredMethods()) {
            assertFalse(m.getName().startsWith("set"), "no setters allowed: " + m.getName());
        }
    }

    @Nested
    @DisplayName("Constructor")
    class Constructor {

        @Test
        void storesCoordinates() {
            GpsLocation connaughtPlace = new GpsLocation(28.6315, 77.2167);
            assertEquals(28.6315, connaughtPlace.getLatitude());
            assertEquals(77.2167, connaughtPlace.getLongitude());
        }

        @Test
        void acceptsBoundaryValues() {
            GpsLocation corner = new GpsLocation(-90, 180);
            assertEquals(-90.0, corner.getLatitude());
            assertEquals(180.0, corner.getLongitude());
            assertEquals(90.0, new GpsLocation(90, -180).getLatitude());
        }

        @Test
        void rejectsOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> new GpsLocation(90.5, 10));
            assertThrows(IllegalArgumentException.class, () -> new GpsLocation(10, -180.01));
            assertThrows(IllegalArgumentException.class, () -> new GpsLocation(Double.NaN, 10));
            assertThrows(IllegalArgumentException.class, () -> new GpsLocation(10, Double.NaN));
        }
    }

    @Nested
    @DisplayName("moveBy()")
    class MoveBy {

        @Test
        void returnsNewObjectAndKeepsOriginal() {
            GpsLocation pickup = new GpsLocation(28.6139, 77.2090);
            GpsLocation moved = pickup.moveBy(0.001, -0.0005);
            assertNotSame(pickup, moved);
            assertEquals(28.6149, moved.getLatitude(), 1e-9);
            assertEquals(77.2085, moved.getLongitude(), 1e-9);
            assertEquals(28.6139, pickup.getLatitude());
            assertEquals(77.2090, pickup.getLongitude());
        }

        @Test
        void outOfRangeMoveThrows() {
            GpsLocation northPoleIsh = new GpsLocation(89.9, 0);
            assertThrows(IllegalArgumentException.class, () -> northPoleIsh.moveBy(0.2, 0));
        }
    }

    @Test
    void formatUsesDirections() {
        assertEquals("28.6139 N, 77.2090 E", new GpsLocation(28.6139, 77.2090).format());
        assertEquals("33.8688 S, 151.2093 E", new GpsLocation(-33.8688, 151.2093).format());
        assertEquals("40.7128 N, 74.0060 W", new GpsLocation(40.7128, -74.0060).format());
        assertEquals("0.0000 N, 0.0000 E", new GpsLocation(0, 0).format());
    }

    @Test
    void finalListIsStillMutableInsideButSafeOutside() {
        GpsLocation stop = new GpsLocation(19.0760, 72.8777);
        stop.addLandmark(" Gate 2 ");
        stop.addLandmark("Chai tapri");
        assertEquals(List.of("Gate 2", "Chai tapri"), stop.getLandmarks());
        assertThrows(UnsupportedOperationException.class, () -> stop.getLandmarks().add("Hack"));
        assertThrows(IllegalArgumentException.class, () -> stop.addLandmark("  "));
        assertTrue(stop.moveBy(0.01, 0.01).getLandmarks().isEmpty());
    }
}
