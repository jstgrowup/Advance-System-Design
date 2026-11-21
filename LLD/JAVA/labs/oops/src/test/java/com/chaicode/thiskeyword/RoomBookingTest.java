package com.chaicode.thiskeyword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("this Keyword - StayEasy Hotels")
class RoomBookingTest {

    @BeforeEach
    void resetIds() {
        RoomBooking.reset();
    }

    @Nested
    @DisplayName("Constructor chaining with this(...)")
    class Chaining {

        @Test
        void nameOnlyUsesAllDefaults() {
            RoomBooking b = new RoomBooking(" Meera ");
            assertEquals("Meera", b.getGuestName());
            assertEquals("STANDARD", b.getRoomType());
            assertEquals(1, b.getNights());
            assertFalse(b.hasBreakfast());
        }

        @Test
        void nameAndRoomType() {
            RoomBooking b = new RoomBooking("Aarav", "suite");
            assertEquals("SUITE", b.getRoomType());
            assertEquals(1, b.getNights());
            assertFalse(b.hasBreakfast());
        }

        @Test
        void nameRoomTypeAndNights() {
            RoomBooking b = new RoomBooking("Aarav", "Deluxe", 4);
            assertEquals("DELUXE", b.getRoomType());
            assertEquals(4, b.getNights());
            assertFalse(b.hasBreakfast());
        }

        @Test
        void fullConstructor() {
            RoomBooking b = new RoomBooking("Aarav", "DELUXE", 2, true);
            assertEquals("Aarav", b.getGuestName());
            assertEquals("DELUXE", b.getRoomType());
            assertEquals(2, b.getNights());
            assertTrue(b.hasBreakfast());
        }

        @Test
        void validationAppliesThroughEveryConstructor() {
            assertThrows(IllegalArgumentException.class, () -> new RoomBooking("  "));
            assertThrows(IllegalArgumentException.class, () -> new RoomBooking(null, "SUITE"));
            assertThrows(IllegalArgumentException.class, () -> new RoomBooking("Aarav", "Penthouse"));
            assertThrows(IllegalArgumentException.class, () -> new RoomBooking("Aarav", "DELUXE", 0));
            assertThrows(IllegalArgumentException.class, () -> new RoomBooking("Aarav", "DELUXE", 31, true));
            assertThrows(IllegalArgumentException.class, () -> new RoomBooking("Aarav", null, 2, false));
        }

        @Test
        void exactlyOneIdPerBookingWhicheverConstructor() {
            assertEquals("SE-101", new RoomBooking("A").getBookingId());
            assertEquals("SE-102", new RoomBooking("B", "SUITE").getBookingId());
            assertThrows(IllegalArgumentException.class, () -> new RoomBooking("C", "SUITE", 99));
            assertEquals("SE-103", new RoomBooking("D", "SUITE", 3).getBookingId());
            assertEquals("SE-104", new RoomBooking("E", "SUITE", 3, true).getBookingId());
        }
    }

    @Test
    void totalCost() {
        assertEquals(2000, new RoomBooking("Meera").totalCost());
        assertEquals(8000, new RoomBooking("Aarav", "DELUXE", 2, true).totalCost());
        assertEquals(18000, new RoomBooking("Kiran", "SUITE", 3).totalCost());
    }

    @Test
    void summary() {
        assertEquals("SE-101 | Aarav | DELUXE x 2 nights | breakfast | Rs. 8000",
                new RoomBooking("Aarav", "DELUXE", 2, true).summary());
        assertEquals("SE-102 | Meera | STANDARD x 1 nights | no breakfast | Rs. 2000",
                new RoomBooking("Meera").summary());
    }
}
