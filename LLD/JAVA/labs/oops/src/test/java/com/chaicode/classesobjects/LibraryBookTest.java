package com.chaicode.classesobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Classes & Objects - ChaiReads Library")
class LibraryBookTest {

    private static LibraryBook newBook(String title, String author, int copies) {
        LibraryBook book = new LibraryBook();
        book.title = title;
        book.author = author;
        book.availableCopies = copies;
        return book;
    }

    @Nested
    @DisplayName("Object state")
    class ObjectState {

        @Test
        void newBookHasDefaultValues() {
            LibraryBook book = new LibraryBook();
            assertNull(book.title);
            assertEquals(0, book.availableCopies);
            assertEquals(0, book.borrowedCount);
        }

        @Test
        void eachBookHasItsOwnState() {
            LibraryBook kalam = newBook("Wings of Fire", "A.P.J. Abdul Kalam", 2);
            LibraryBook premchand = newBook("Godaan", "Munshi Premchand", 2);
            assertTrue(kalam.borrow());
            assertEquals(1, kalam.availableCopies);
            assertEquals(2, premchand.availableCopies);
            assertEquals(0, premchand.borrowedCount);
        }

        @Test
        void twoReferencesShareSameBook() {
            LibraryBook book = newBook("Wings of Fire", "A.P.J. Abdul Kalam", 3);
            LibraryBook shelfLabel = book;
            shelfLabel.borrow();
            assertSame(book, shelfLabel);
            assertEquals(2, book.availableCopies);
            assertEquals(1, book.borrowedCount);
        }
    }

    @Nested
    @DisplayName("addCopies()")
    class AddCopies {

        @Test
        void addsCopiesAndMakesBookAvailable() {
            LibraryBook book = newBook("Godaan", "Munshi Premchand", 0);
            assertFalse(book.isAvailable());
            book.addCopies(2);
            book.addCopies(1);
            assertEquals(3, book.availableCopies);
            assertTrue(book.isAvailable());
        }

        @Test
        void ignoresNonPositiveCount() {
            LibraryBook book = newBook("Godaan", "Munshi Premchand", 0);
            book.addCopies(4);
            book.addCopies(0);
            book.addCopies(-3);
            assertEquals(4, book.availableCopies);
        }
    }

    @Nested
    @DisplayName("borrow() and returnBook()")
    class BorrowAndReturn {

        @Test
        void borrowFailsWhenShelfIsEmpty() {
            LibraryBook book = newBook("Wings of Fire", "A.P.J. Abdul Kalam", 1);
            assertTrue(book.borrow());
            assertFalse(book.borrow());
            assertEquals(0, book.availableCopies);
            assertEquals(1, book.borrowedCount);
            assertFalse(book.isAvailable());
        }

        @Test
        void returnPutsCopyBackOnShelf() {
            LibraryBook book = newBook("Wings of Fire", "A.P.J. Abdul Kalam", 2);
            book.borrow();
            book.borrow();
            assertTrue(book.returnBook());
            assertEquals(1, book.availableCopies);
            assertEquals(1, book.borrowedCount);
        }

        @Test
        void cannotReturnMoreThanBorrowed() {
            LibraryBook book = newBook("Wings of Fire", "A.P.J. Abdul Kalam", 2);
            assertTrue(book.borrow());
            assertTrue(book.returnBook());
            assertFalse(book.returnBook());
            assertEquals(2, book.availableCopies);
            assertEquals(0, book.borrowedCount);
        }
    }

    @Test
    void describe() {
        LibraryBook book = newBook("Wings of Fire", "A.P.J. Abdul Kalam", 3);
        book.borrow();
        assertEquals("Wings of Fire by A.P.J. Abdul Kalam | Available: 2 | Borrowed: 1", book.describe());
    }
}
