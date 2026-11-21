package com.chaicode.classesobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Classes & Objects - Starlight Cinema")
class MovieTicketTest {

    private static MovieTicket newTicket(String movie, String seat, double price) {
        MovieTicket ticket = new MovieTicket();
        ticket.movie = movie;
        ticket.seat = seat;
        ticket.price = price;
        return ticket;
    }

    @Nested
    @DisplayName("Object state")
    class ObjectState {

        @Test
        void newTicketHasDefaultValues() {
            MovieTicket ticket = new MovieTicket();
            assertNull(ticket.movie);
            assertEquals(0.0, ticket.price, 0.001);
            assertFalse(ticket.cancelled);
        }

        @Test
        void twoTicketsAreIndependent() {
            MovieTicket riya = newTicket("Jawan", "F12", 250.0);
            MovieTicket aman = newTicket("Jawan", "F13", 250.0);
            assertTrue(riya.applyDiscount(10));
            riya.cancel();
            assertEquals(225.0, riya.price, 0.001);
            assertTrue(riya.cancelled);
            assertEquals(250.0, aman.price, 0.001);
            assertFalse(aman.cancelled);
        }
    }

    @Nested
    @DisplayName("applyDiscount()")
    class ApplyDiscount {

        @Test
        void reducesPrice() {
            MovieTicket ticket = newTicket("Jawan", "F12", 250.0);
            assertTrue(ticket.applyDiscount(20));
            assertEquals(200.0, ticket.price, 0.001);
        }

        @Test
        void roundsToTwoDecimals() {
            MovieTicket ticket = newTicket("Pathaan", "A1", 199.99);
            assertTrue(ticket.applyDiscount(15));
            assertEquals(169.99, ticket.price, 0.001);
        }

        @Test
        void rejectsInvalidPercent() {
            MovieTicket ticket = newTicket("Jawan", "F12", 250.0);
            assertFalse(ticket.applyDiscount(0));
            assertFalse(ticket.applyDiscount(51));
            assertFalse(ticket.applyDiscount(-10));
            assertTrue(ticket.applyDiscount(50));
            assertEquals(125.0, ticket.price, 0.001);
        }

        @Test
        void cannotDiscountCancelledTicket() {
            MovieTicket ticket = newTicket("Jawan", "F12", 250.0);
            ticket.cancel();
            assertTrue(ticket.cancelled);
            assertFalse(ticket.applyDiscount(10));
            assertEquals(250.0, ticket.price, 0.001);
        }
    }

    @Nested
    @DisplayName("cancel()")
    class Cancel {

        @Test
        void refundsEightyPercent() {
            MovieTicket ticket = newTicket("Jawan", "F12", 250.0);
            assertEquals(200.0, ticket.cancel(), 0.001);
            assertTrue(ticket.cancelled);
            assertEquals(250.0, ticket.price, 0.001);
        }

        @Test
        void secondCancelRefundsNothing() {
            MovieTicket ticket = newTicket("Pathaan", "A1", 169.99);
            assertEquals(135.99, ticket.cancel(), 0.001);
            assertEquals(0.0, ticket.cancel(), 0.001);
            assertTrue(ticket.cancelled);
        }
    }

    @Test
    void describeActiveAndCancelled() {
        MovieTicket ticket = newTicket("Jawan", "F12", 250.0);
        assertEquals("Jawan | Seat: F12 | Rs. 250.00", ticket.describe());
        ticket.cancel();
        assertEquals("Jawan | Seat: F12 | CANCELLED", ticket.describe());
    }
}
