package com.chaicode.encapsulation;

/**
 * St. Mary's School Report Cards — ReportCard
 *
 * <p>Ms. Parker caught a student "fixing" his own result with
 * {@code card.marks = 100;}. Time to lock the data down: nobody outside this class
 * may touch the fields directly — every change must go through a method that
 * validates it first.
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>studentName — e.g. "Aarav"</li>
 *   <li>marks — 0 to 100 (starts at 0)</li>
 * </ul>
 * Make BOTH fields {@code private}. Do NOT add a {@code grade} field — the grade is always
 * derived from marks.
 *
 * <p>Implement:
 * <ul>
 *   <li>Constructor {@code ReportCard(String studentName)}: store the name; marks start at 0.</li>
 *   <li>{@code getStudentName()} and {@code getMarks()}: plain getters.</li>
 *   <li>{@code setMarks(int marks)}: accept only 0 to 100 (both inclusive). Anything else must
 *     throw {@code IllegalArgumentException} and leave the previous marks unchanged.</li>
 *   <li>{@code getGrade()}: compute from the current marks every time:
 *     <pre>
 * 90 - 100  "A"
 * 75 - 89   "B"
 * 60 - 74   "C"
 * 40 - 59   "D"
 *  0 - 39   "F"
 *     </pre></li>
 *   <li>{@code isPassed()}: true when marks &gt;= 40.</li>
 * </ul>
 */
public class ReportCard {

    String studentName;
    int marks;

    public ReportCard(String studentName) {
        // Your code here
    }

    public String getStudentName() {
        // Your code here
        return "";
    }

    public int getMarks() {
        // Your code here
        return 0;
    }

    public void setMarks(int marks) {
        // Your code here
    }

    public String getGrade() {
        // Your code here
        return "";
    }

    public boolean isPassed() {
        // Your code here
        return false;
    }
}
