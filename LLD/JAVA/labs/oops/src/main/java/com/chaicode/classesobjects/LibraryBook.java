package com.chaicode.classesobjects;

/**
 * ChaiReads Library — LibraryBook
 *
 * <p>ChaiReads is a tiny neighbourhood library that runs out of a chai tapri. Every book on
 * the shelf is an object created from this single {@code LibraryBook} blueprint, and each
 * book object tracks its OWN copies — borrowing "Wings of Fire" must never change "Godaan".
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>title — e.g. "Wings of Fire"</li>
 *   <li>author — e.g. "A.P.J. Abdul Kalam"</li>
 *   <li>availableCopies — copies on the shelf right now (starts at the default value 0)</li>
 *   <li>borrowedCount — copies currently with readers (starts at the default value 0)</li>
 * </ul>
 *
 * <p>Implement these methods:
 * <ul>
 *   <li>{@code addCopies(int count)}: put count new copies on the shelf (add to
 *     availableCopies). Ignore count &lt;= 0.</li>
 *   <li>{@code borrow()}: if at least one copy is available, move one copy from the shelf to
 *     the reader (availableCopies - 1, borrowedCount + 1) and return true. Otherwise change
 *     nothing and return false.</li>
 *   <li>{@code returnBook()}: if borrowedCount &gt; 0, move one copy back to the shelf
 *     (borrowedCount - 1, availableCopies + 1) and return true. A copy that was never borrowed
 *     cannot be returned: change nothing and return false.</li>
 *   <li>{@code isAvailable()}: true when availableCopies &gt; 0, otherwise false.</li>
 *   <li>{@code describe()}: return exactly
 *     <pre>Wings of Fire by A.P.J. Abdul Kalam | Available: 2 | Borrowed: 1</pre></li>
 * </ul>
 */
public class LibraryBook {

    String title;
    String author;
    int availableCopies;
    int borrowedCount;

    public void addCopies(int count) {
        // Your code here
    }

    public boolean borrow() {
        // Your code here
        return false;
    }

    public boolean returnBook() {
        // Your code here
        return false;
    }

    public boolean isAvailable() {
        // Your code here
        return false;
    }

    public String describe() {
        // Your code here
        return "";
    }
}
