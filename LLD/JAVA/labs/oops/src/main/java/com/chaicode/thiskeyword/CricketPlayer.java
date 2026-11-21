package com.chaicode.thiskeyword;

/**
 * Gully Cricket League — CricketPlayer
 *
 * <p>A player in the Gully Cricket League. Read the rules in {@link CricketTeam} first; the
 * two classes work together.
 *
 * <p>Every parameter below has the SAME name as a field, so inside these methods the bare
 * name means the parameter — use {@code this.name}, {@code this.runs}, {@code this.team} to
 * reach the fields.
 *
 * <ul>
 *   <li>{@code CricketPlayer(String name, int runs)}: store both values in the fields.</li>
 *   <li>{@code addRuns(int runs)}: add runs to this player's runs. Ignore runs &lt;= 0.</li>
 *   <li>{@code joinTeam(CricketTeam team)}: return false if team is null or this player is
 *     already in a team. Otherwise ask the team to accept THIS player by calling
 *     {@code team.addPlayer(this)}. Only if the team accepted (returned true) remember the
 *     team in the team field. Return what the team returned.</li>
 * </ul>
 */
public class CricketPlayer {

    private String name;
    private int runs;
    private CricketTeam team;

    public CricketPlayer(String name, int runs) {
        // Your code here
    }

    public void addRuns(int runs) {
        // Your code here
    }

    public boolean joinTeam(CricketTeam team) {
        // Your code here
        return false;
    }

    public String getName() {
        return name;
    }

    public int getRuns() {
        return runs;
    }

    public CricketTeam getTeam() {
        return team;
    }
}
