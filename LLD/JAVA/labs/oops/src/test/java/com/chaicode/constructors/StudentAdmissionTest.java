package com.chaicode.constructors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Constructors - ChaiCode Academy Admissions")
class StudentAdmissionTest {

    @Nested
    @DisplayName("No-arg constructor")
    class NoArg {

        @Test
        void usesDocumentedDefaults() {
            StudentAdmission guest = new StudentAdmission();
            assertEquals("Guest", guest.name);
            assertEquals("Java Basics", guest.course);
            assertEquals(18, guest.age);
            assertEquals(4999, guest.fee);
            assertEquals(0, guest.rollNumber);
        }
    }

    @Nested
    @DisplayName("Parameterized constructor")
    class Parameterized {

        @Test
        void setsTrimmedFieldsAndStandardFee() {
            StudentAdmission s = new StudentAdmission("  Riya Sharma ", " DSA ", 21);
            assertEquals("Riya Sharma", s.name);
            assertEquals("DSA", s.course);
            assertEquals(21, s.age);
            assertEquals(4999, s.fee);
        }

        @Test
        void juniorFeeBelowEighteen() {
            assertEquals(2999, new StudentAdmission("Kabir", "Web Dev", 16).fee);
            assertEquals(2999, new StudentAdmission("Kabir", "Web Dev", 17).fee);
            assertEquals(4999, new StudentAdmission("Kabir", "Web Dev", 18).fee);
        }

        @Test
        void rejectsMissingName() {
            assertThrows(IllegalArgumentException.class, () -> new StudentAdmission(null, "DSA", 20));
            assertThrows(IllegalArgumentException.class, () -> new StudentAdmission("   ", "DSA", 20));
        }

        @Test
        void rejectsMissingCourse() {
            assertThrows(IllegalArgumentException.class, () -> new StudentAdmission("Riya", null, 20));
            assertThrows(IllegalArgumentException.class, () -> new StudentAdmission("Riya", "", 20));
        }

        @Test
        void rejectsAgeOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> new StudentAdmission("Riya", "DSA", 15));
            assertThrows(IllegalArgumentException.class, () -> new StudentAdmission("Riya", "DSA", 61));
            assertEquals(60, new StudentAdmission("Riya", "DSA", 60).age);
        }
    }

    @Nested
    @DisplayName("Roll number")
    class RollNumber {

        @Test
        void startsAtDefaultZeroAndIsAssignedOnce() {
            StudentAdmission s = new StudentAdmission("Riya", "DSA", 21);
            assertEquals(0, s.rollNumber);
            assertTrue(s.assignRollNumber(101));
            assertFalse(s.assignRollNumber(202));
            assertEquals(101, s.rollNumber);
        }

        @Test
        void rejectsNonPositiveRoll() {
            StudentAdmission s = new StudentAdmission();
            assertFalse(s.assignRollNumber(0));
            assertFalse(s.assignRollNumber(-5));
            assertEquals(0, s.rollNumber);
            assertTrue(s.assignRollNumber(7));
        }
    }

    @Test
    void summary() {
        StudentAdmission s = new StudentAdmission("Riya Sharma", "DSA", 21);
        s.assignRollNumber(101);
        assertEquals("#101 Riya Sharma | DSA | Age 21 | Fee Rs. 4999", s.summary());
        assertEquals("#0 Guest | Java Basics | Age 18 | Fee Rs. 4999", new StudentAdmission().summary());
    }
}
