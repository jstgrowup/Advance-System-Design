package com.chaicode.thiskeyword;

/**
 * StayEasy Hotels — RoomBooking
 *
 * <p>At the StayEasy front desk most guests just say their name; some also pick a room
 * type, some the number of nights, and a few want breakfast too. {@code RoomBooking} offers
 * four constructors, but the real work (validation, storing fields, generating the booking
 * id) must live in ONE place — the full 4-argument constructor. Every shorter constructor
 * must forward to the next longer one using {@code this(...)} as its FIRST statement:
 * <pre>
 * RoomBooking(guestName)                           → this(guestName, "STANDARD")
 * RoomBooking(guestName, roomType)                 → this(guestName, roomType, 1)
 * RoomBooking(guestName, roomType, nights)         → this(guestName, roomType, nights, false)
 * RoomBooking(guestName, roomType, nights, breakfast)   ← does all the work
 * </pre>
 * Defaults: roomType = "STANDARD", nights = 1, breakfast = false.
 *
 * <p>Full constructor rules — validate in this order, throwing
 * {@link IllegalArgumentException} on the first failure:
 * <ol>
 *   <li>guestName null or blank (after trim).</li>
 *   <li>roomType null or not "STANDARD", "DELUXE", "SUITE" (ignoring case).</li>
 *   <li>nights less than 1 or greater than 30.</li>
 * </ol>
 * Then store the TRIMMED guest name, the room type in UPPERCASE, nights and breakfast, and
 * assign {@code bookingId = "SE-" + nextId}, then increase nextId by 1. A booking that fails
 * validation must NOT use up an id. Each booking object must consume exactly one id, no matter
 * which constructor was called (ids go SE-101, SE-102, ...). {@code reset()} sets nextId back
 * to 101 (used by tests).
 *
 * <p>Methods:
 * <ul>
 *   <li>{@code totalCost()}: nightly rate STANDARD = 2000, DELUXE = 3500, SUITE = 6000, plus
 *     500 per night for breakfast; multiplied by nights.</li>
 *   <li>{@code summary()}: return exactly (the word "nights" is always plural)
 *     <pre>SE-101 | Aarav | DELUXE x 2 nights | breakfast | Rs. 8000</pre>
 *     or, without breakfast,
 *     <pre>SE-102 | Meera | STANDARD x 1 nights | no breakfast | Rs. 2000</pre></li>
 * </ul>
 */
public class RoomBooking {

    private static int nextId = 101;

    private String bookingId;
    private String guestName;
    private String roomType;
    private int nights;
    private boolean breakfast;

    public RoomBooking(String guestName) {
        // Your code here
    }

    public RoomBooking(String guestName, String roomType) {
        // Your code here
    }

    public RoomBooking(String guestName, String roomType, int nights) {
        // Your code here
    }

    public RoomBooking(String guestName, String roomType, int nights, boolean breakfast) {
        // Your code here
    }

    static void reset() {
        nextId = 101;
    }

    public int totalCost() {
        // Your code here
        return 0;
    }

    public String summary() {
        // Your code here
        return "";
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    public boolean hasBreakfast() {
        return breakfast;
    }
}
