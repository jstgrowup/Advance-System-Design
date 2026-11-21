package com.chaicode.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Enums - Zippy Order Tracking")
class OrderStatusTest {

    @Nested
    @DisplayName("State machine")
    class StateMachine {

        @Test
        void nextFollowsTheHappyPath() {
            assertSame(OrderStatus.CONFIRMED, OrderStatus.PLACED.next());
            assertSame(OrderStatus.PREPARING, OrderStatus.CONFIRMED.next());
            assertSame(OrderStatus.OUT_FOR_DELIVERY, OrderStatus.PREPARING.next());
            assertSame(OrderStatus.DELIVERED, OrderStatus.OUT_FOR_DELIVERY.next());
        }

        @Test
        void terminalStatesStayPut() {
            assertTrue(OrderStatus.DELIVERED.isTerminal());
            assertTrue(OrderStatus.CANCELLED.isTerminal());
            assertFalse(OrderStatus.PLACED.isTerminal());
            assertFalse(OrderStatus.OUT_FOR_DELIVERY.isTerminal());
            assertSame(OrderStatus.DELIVERED, OrderStatus.DELIVERED.next());
            assertSame(OrderStatus.CANCELLED, OrderStatus.CANCELLED.next());
        }

        @Test
        void canOnlyMoveOneStepForward() {
            assertTrue(OrderStatus.PLACED.canTransitionTo(OrderStatus.CONFIRMED));
            assertTrue(OrderStatus.OUT_FOR_DELIVERY.canTransitionTo(OrderStatus.DELIVERED));
            assertFalse(OrderStatus.PLACED.canTransitionTo(OrderStatus.PREPARING));
            assertFalse(OrderStatus.PREPARING.canTransitionTo(OrderStatus.CONFIRMED));
            assertFalse(OrderStatus.CONFIRMED.canTransitionTo(OrderStatus.CONFIRMED));
            assertFalse(OrderStatus.PLACED.canTransitionTo(null));
        }

        @Test
        void cancellationRules() {
            assertTrue(OrderStatus.PLACED.canTransitionTo(OrderStatus.CANCELLED));
            assertTrue(OrderStatus.CONFIRMED.canTransitionTo(OrderStatus.CANCELLED));
            assertTrue(OrderStatus.PREPARING.canTransitionTo(OrderStatus.CANCELLED));
            assertFalse(OrderStatus.OUT_FOR_DELIVERY.canTransitionTo(OrderStatus.CANCELLED));
            assertFalse(OrderStatus.DELIVERED.canTransitionTo(OrderStatus.CANCELLED));
            assertFalse(OrderStatus.CANCELLED.canTransitionTo(OrderStatus.PLACED));
        }
    }

    @Nested
    @DisplayName("Constant-specific behaviour")
    class ConstantBodies {

        @Test
        void eachConstantHasItsOwnMessage() throws NoSuchMethodException {
            assertEquals("We have received your order", OrderStatus.PLACED.customerMessage());
            assertEquals("Restaurant has accepted your order", OrderStatus.CONFIRMED.customerMessage());
            assertEquals("Your food is being prepared", OrderStatus.PREPARING.customerMessage());
            assertEquals("Your rider is on the way", OrderStatus.OUT_FOR_DELIVERY.customerMessage());
            assertEquals("Enjoy your meal!", OrderStatus.DELIVERED.customerMessage());
            assertEquals("Your order was cancelled", OrderStatus.CANCELLED.customerMessage());
            assertTrue(Modifier.isAbstract(OrderStatus.class.getDeclaredMethod("customerMessage").getModifiers()));
            assertNotEquals(OrderStatus.class, OrderStatus.PLACED.getClass());
            assertSame(OrderStatus.class, OrderStatus.PLACED.getDeclaringClass());
        }

        @Test
        void etaMinutesPerState() {
            assertEquals(40, OrderStatus.PLACED.etaMinutes());
            assertEquals(35, OrderStatus.CONFIRMED.etaMinutes());
            assertEquals(25, OrderStatus.PREPARING.etaMinutes());
            assertEquals(10, OrderStatus.OUT_FOR_DELIVERY.etaMinutes());
            assertEquals(0, OrderStatus.DELIVERED.etaMinutes());
            assertEquals(0, OrderStatus.CANCELLED.etaMinutes());
        }

        @Test
        void trackingLineFormat() {
            assertEquals("PREPARING: Your food is being prepared (ETA 25 min)", OrderStatus.PREPARING.trackingLine());
            assertEquals("OUT_FOR_DELIVERY: Your rider is on the way (ETA 10 min)",
                    OrderStatus.OUT_FOR_DELIVERY.trackingLine());
            assertEquals("DELIVERED: Enjoy your meal!", OrderStatus.DELIVERED.trackingLine());
            assertEquals("CANCELLED: Your order was cancelled", OrderStatus.CANCELLED.trackingLine());
        }
    }
}
