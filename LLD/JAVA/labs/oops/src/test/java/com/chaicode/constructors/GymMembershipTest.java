package com.chaicode.constructors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Constructors - FitZone Gym")
class GymMembershipTest {

    @Nested
    @DisplayName("Constructor computes derived fields")
    class ConstructorTests {

        @Test
        void computesMonthsAndFeeFromPlan() {
            GymMembership monthly = new GymMembership("Rohit", "MONTHLY");
            GymMembership quarterly = new GymMembership("Rohit", "QUARTERLY");
            GymMembership yearly = new GymMembership("Rohit", "YEARLY");
            assertEquals(1, monthly.monthsRemaining);
            assertEquals(1500, monthly.totalFeePaid);
            assertEquals(3, quarterly.monthsRemaining);
            assertEquals(4000, quarterly.totalFeePaid);
            assertEquals(12, yearly.monthsRemaining);
            assertEquals(12000, yearly.totalFeePaid);
            assertEquals(0, yearly.renewals);
        }

        @Test
        void trimsNameAndUppercasesPlan() {
            GymMembership m = new GymMembership("  Sneha ", "quarterly");
            assertEquals("Sneha", m.memberName);
            assertEquals("QUARTERLY", m.plan);
            assertTrue(m.isActive());
        }

        @Test
        void rejectsInvalidInput() {
            assertThrows(IllegalArgumentException.class, () -> new GymMembership(null, "MONTHLY"));
            assertThrows(IllegalArgumentException.class, () -> new GymMembership("  ", "MONTHLY"));
            assertThrows(IllegalArgumentException.class, () -> new GymMembership("Rohit", "WEEKLY"));
            assertThrows(IllegalArgumentException.class, () -> new GymMembership("Rohit", null));
        }
    }

    @Nested
    @DisplayName("renew() is a method on the same object")
    class Renew {

        @Test
        void renewAddsMonthsAndDiscountedFee() {
            GymMembership m = new GymMembership("Rohit", "QUARTERLY");
            assertEquals(3600, m.renew());
            assertEquals(6, m.monthsRemaining);
            assertEquals(7600, m.totalFeePaid);
            assertEquals(1, m.renewals);
        }

        @Test
        void renewCanBeCalledManyTimes() {
            GymMembership m = new GymMembership("Rohit", "MONTHLY");
            assertEquals(1350, m.renew());
            assertEquals(1350, m.renew());
            assertEquals(3, m.monthsRemaining);
            assertEquals(4200, m.totalFeePaid);
            assertEquals(2, m.renewals);
        }

        @Test
        void newObjectStartsFreshWhileOldKeepsHistory() {
            GymMembership old = new GymMembership("Rohit", "YEARLY");
            old.renew();
            GymMembership fresh = new GymMembership("Rohit", "YEARLY");
            assertEquals(24, old.monthsRemaining);
            assertEquals(22800, old.totalFeePaid);
            assertEquals(12, fresh.monthsRemaining);
            assertEquals(0, fresh.renewals);
        }
    }

    @Test
    void completeMonthUntilExpired() {
        GymMembership m = new GymMembership("Rohit", "MONTHLY");
        assertTrue(m.completeMonth());
        assertEquals(0, m.monthsRemaining);
        assertFalse(m.isActive());
        assertFalse(m.completeMonth());
        assertEquals(0, m.monthsRemaining);
    }

    @Test
    void describe() {
        GymMembership m = new GymMembership("Rohit", "QUARTERLY");
        assertEquals("Rohit | QUARTERLY | 3 months left | Paid Rs. 4000 | Renewals: 0", m.describe());
        m.renew();
        assertEquals("Rohit | QUARTERLY | 6 months left | Paid Rs. 7600 | Renewals: 1", m.describe());
    }
}
