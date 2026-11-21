package com.chaicode.constructors;

/**
 * ChaiCode Academy Admissions — StudentAdmission
 *
 * <p>ChaiCode Academy creates one {@code StudentAdmission} object per applicant. Walk-in
 * visitors get a quick "guest" admission with sensible defaults, while real applicants fill
 * the full form. The constructor is the gatekeeper: a bad form must never produce an object.
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>name, course, age, fee (in rupees, whole number)</li>
 *   <li>rollNumber — NOT set by any constructor, so it keeps its default value 0
 *     ("not assigned yet") until {@code assignRollNumber} is called</li>
 * </ul>
 *
 * <p>Constructors:
 * <ol>
 *   <li>{@code StudentAdmission()} (no-arg): name = "Guest", course = "Java Basics",
 *     age = 18, fee = 4999.</li>
 *   <li>{@code StudentAdmission(String name, String course, int age)}: validate in this
 *     order and throw {@link IllegalArgumentException} on the first failure:
 *     <ol>
 *       <li>name is null or blank (after trim)</li>
 *       <li>course is null or blank (after trim)</li>
 *       <li>age is less than 16 or greater than 60</li>
 *     </ol>
 *     Then store the TRIMMED name and course, store age, and set fee = 2999 when
 *     age &lt; 18 (junior batch), otherwise 4999.</li>
 * </ol>
 *
 * <p>Methods:
 * <ul>
 *   <li>{@code assignRollNumber(int roll)}: return false (and change nothing) if roll &lt;= 0
 *     or a roll number is already assigned (rollNumber != 0). Otherwise store it and return
 *     true.</li>
 *   <li>{@code summary()}: return exactly
 *     <pre>#101 Riya Sharma | DSA | Age 21 | Fee Rs. 4999</pre>
 *     (an unassigned roll number shows as {@code #0}).</li>
 * </ul>
 */
public class StudentAdmission {

    String name;
    String course;
    int age;
    int fee;
    int rollNumber;

    public StudentAdmission() {
        // Your code here
    }

    public StudentAdmission(String name, String course, int age) {
        // Your code here
    }

    public boolean assignRollNumber(int roll) {
        // Your code here
        return false;
    }

    public String summary() {
        // Your code here
        return "";
    }
}
