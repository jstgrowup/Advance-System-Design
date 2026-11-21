package com.chaicode.polymorphism;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Polymorphism - ChaiKart Checkout")
class PaymentTest {

    @Nested
    @DisplayName("Parent Payment")
    class Parent {

        @Test
        void genericReceipt() {
            Payment p = new Payment(100);
            assertEquals(100.0, p.getAmount(), 0.001);
            assertEquals(0.0, p.fee(), 0.001);
            assertEquals(100.0, p.total(), 0.001);
            assertEquals("GENERIC | Amount: 100.00 | Fee: 0.00 | Total: 100.00", p.receipt());
        }

        @Test
        void rejectsNonPositiveAmount() {
            assertThrows(IllegalArgumentException.class, () -> new Payment(0));
            assertThrows(IllegalArgumentException.class, () -> new CardPayment(-10));
            assertThrows(IllegalArgumentException.class, () -> new UpiPayment(0, "chai@okaxis"));
        }
    }

    @Nested
    @DisplayName("Parent reference, child object")
    class RuntimeDispatch {

        @Test
        void upiHasNoFeeAndExtendsReceipt() {
            Payment p = new UpiPayment(250, "chai@okaxis");
            assertEquals("UPI", p.method());
            assertEquals(250.0, p.total(), 0.001);
            assertEquals("UPI | Amount: 250.00 | Fee: 0.00 | Total: 250.00 | UPI ID: chai@okaxis", p.receipt());
            assertEquals("chai@okaxis", ((UpiPayment) p).getUpiId());
        }

        @Test
        void cardFeeIsTwoPercentRounded() {
            Payment p = new CardPayment(1000);
            assertEquals("CARD", p.method());
            assertEquals(20.0, p.fee(), 0.001);
            assertEquals(1020.0, p.total(), 0.001);

            Payment odd = new CardPayment(333.33);
            assertEquals(6.67, odd.fee(), 0.0001);
            assertEquals(340.0, odd.total(), 0.0001);
        }

        @Test
        void cashChargesOnlySmallOrders() {
            Payment small = new CashPayment(499.99);
            Payment big = new CashPayment(500);
            assertEquals("CASH", small.method());
            assertEquals(20.0, small.fee(), 0.001);
            assertEquals(0.0, big.fee(), 0.001);
            assertEquals("CASH | Amount: 300.00 | Fee: 20.00 | Total: 320.00", new CashPayment(300).receipt());
        }
    }

    @Nested
    @DisplayName("PaymentProcessor")
    class Processor {

        private final List<Payment> mixed = List.of(
                new UpiPayment(250, "chai@okaxis"),
                new CardPayment(1000),
                new CashPayment(300));

        @Test
        void totalsAMixedList() {
            PaymentProcessor processor = new PaymentProcessor();
            assertEquals(1590.0, processor.totalCollected(mixed), 0.001);
            assertEquals(40.0, processor.totalFees(mixed), 0.001);
            assertEquals(0.0, processor.totalCollected(List.of()), 0.001);
        }

        @Test
        void receiptsInOrder() {
            assertEquals(List.of(
                    "UPI | Amount: 250.00 | Fee: 0.00 | Total: 250.00 | UPI ID: chai@okaxis",
                    "CARD | Amount: 1000.00 | Fee: 20.00 | Total: 1020.00",
                    "CASH | Amount: 300.00 | Fee: 20.00 | Total: 320.00"),
                    new PaymentProcessor().receipts(mixed));
        }
    }
}
