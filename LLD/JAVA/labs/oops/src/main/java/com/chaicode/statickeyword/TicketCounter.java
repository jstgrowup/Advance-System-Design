package com.chaicode.statickeyword;

/**
 * Namma Metro Token Machine — TicketCounter
 *
 * <p>Every metro station has its own token machine (one {@code TicketCounter} object per
 * station), but token numbers come from ONE shared sequence for the whole metro network.
 * So a machine must remember how many tokens IT issued (instance state), while the network
 * total is shared by every machine (static state).
 *
 * <p>Fields (already declared — do not rename them):
 * <ul>
 *   <li>{@code stationName} — e.g. "Rajiv Chowk" (one per machine)</li>
 *   <li>{@code issuedHere} — tokens issued by THIS machine (one per machine)</li>
 *   <li>{@code totalTokens} — tokens issued by ALL machines together.
 *     <b>Make this field {@code static}</b> so there is only one shared copy
 *     (a test checks it with reflection). Keep {@code issuedHere} an instance field.</li>
 * </ul>
 *
 * <p>Implement:
 * <ul>
 *   <li>Constructor {@code TicketCounter(String stationName)}: store the name (trimmed).
 *     If it is null or blank, throw {@code IllegalArgumentException}. A new machine has
 *     issued 0 tokens.</li>
 *   <li>{@code getStationName()}: return the stored name.</li>
 *   <li>{@code issueToken()}: increase this machine's count AND the shared total by 1, then
 *     return the token id built from the NEW shared total: {@code "MT-"} followed by the number
 *     padded with zeros to 4 digits (use {@code String.format("MT-%04d", n)}).
 *     <pre>1st token in the network -&gt; MT-0001
 * 2nd token (any machine)    -&gt; MT-0002
 * 12th token                 -&gt; MT-0012</pre></li>
 *   <li>{@code getIssuedHere()}: tokens issued by this machine.</li>
 *   <li>{@code static totalIssued()}: tokens issued by all machines together.</li>
 *   <li>{@code static reset()}: set the shared total back to 0 (used by tests, so every test
 *     starts with MT-0001).</li>
 *   <li>{@code describe()}: return exactly
 *     <pre>Rajiv Chowk | here: 2 | network: 5</pre></li>
 * </ul>
 *
 * <p>Hint: a static method has no {@code this}, so it can only use static fields directly.
 */
public class TicketCounter {

    private String stationName;
    private int issuedHere;
    private int totalTokens;

    public TicketCounter(String stationName) {
        // Your code here
    }

    public String getStationName() {
        // Your code here
        return null;
    }

    public String issueToken() {
        // Your code here
        return "";
    }

    public int getIssuedHere() {
        // Your code here
        return 0;
    }

    public static int totalIssued() {
        // Your code here
        return 0;
    }

    public static void reset() {
        // Your code here
    }

    public String describe() {
        // Your code here
        return "";
    }
}
