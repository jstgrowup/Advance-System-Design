package com.chaicode.encapsulation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Encapsulation - St. Mary's Report Card")
class ReportCardTest {

    @Test
    void fieldsArePrivateAndGradeIsNotStored() throws NoSuchFieldException {
        Field name = ReportCard.class.getDeclaredField("studentName");
        Field marks = ReportCard.class.getDeclaredField("marks");
        assertTrue(Modifier.isPrivate(name.getModifiers()), "studentName must be private");
        assertTrue(Modifier.isPrivate(marks.getModifiers()), "marks must be private");
        assertThrows(NoSuchFieldException.class, () -> ReportCard.class.getDeclaredField("grade"));
    }

    @Test
    void constructorStoresNameAndStartsAtZero() {
        ReportCard card = new ReportCard("Aarav");
        assertEquals("Aarav", card.getStudentName());
        assertEquals(0, card.getMarks());
    }

    @Nested
    @DisplayName("setMarks()")
    class SetMarks {

        @Test
        void storesValidMarks() {
            ReportCard card = new ReportCard("Aarav");
            card.setMarks(85);
            assertEquals(85, card.getMarks());
        }

        @Test
        void acceptsBoundaryValues() {
            ReportCard card = new ReportCard("Aarav");
            card.setMarks(100);
            assertEquals(100, card.getMarks());
            card.setMarks(0);
            assertEquals(0, card.getMarks());
        }

        @Test
        void rejectsOutOfRangeMarks() {
            ReportCard card = new ReportCard("Aarav");
            assertThrows(IllegalArgumentException.class, () -> card.setMarks(-1));
            assertThrows(IllegalArgumentException.class, () -> card.setMarks(101));
            assertThrows(IllegalArgumentException.class, () -> card.setMarks(500));
        }

        @Test
        void invalidMarksKeepPreviousValue() {
            ReportCard card = new ReportCard("Aarav");
            card.setMarks(70);
            assertThrows(IllegalArgumentException.class, () -> card.setMarks(150));
            assertEquals(70, card.getMarks());
        }
    }

    @Nested
    @DisplayName("Derived values")
    class Derived {

        @Test
        void gradeFollowsMarks() {
            ReportCard card = new ReportCard("Diya");
            int[] marks = {100, 90, 89, 75, 74, 60, 59, 40, 39, 0};
            String[] grades = {"A", "A", "B", "B", "C", "C", "D", "D", "F", "F"};
            for (int i = 0; i < marks.length; i++) {
                card.setMarks(marks[i]);
                assertEquals(grades[i], card.getGrade(), "marks " + marks[i]);
            }
        }

        @Test
        void passMarkIsForty() {
            ReportCard card = new ReportCard("Diya");
            card.setMarks(40);
            assertTrue(card.isPassed());
            card.setMarks(39);
            assertFalse(card.isPassed());
        }
    }
}
