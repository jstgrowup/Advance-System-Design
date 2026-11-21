package com.chaicode.thiskeyword;

import java.util.ArrayList;
import java.util.List;

/**
 * Gully Cricket League — CricketTeam
 *
 * <p>Every Sunday the colony kids form teams for the Gully Cricket League. A player joins a
 * team by calling {@code player.joinTeam(team)}; inside that method the player hands ITSELF
 * over with {@code team.addPlayer(this)}. So after joining, the team's list holds the very
 * same player object, and the player remembers the very same team object.
 *
 * <p>You also implement {@link CricketPlayer} — do both.
 *
 * <p>Constructor parameters have the same names as the fields — use {@code this.field}.
 *
 * <ul>
 *   <li>{@code CricketTeam(String name, int maxPlayers)}: store both values.</li>
 *   <li>{@code addPlayer(CricketPlayer player)}: return false (and add nothing) if player is
 *     null, the same player object is already in the team, or the team already has
 *     maxPlayers players. Otherwise add the player to the end of players and return true.</li>
 *   <li>{@code getPlayers()}: return a NEW list (a copy) containing the players in joining
 *     order — changing the returned list must not change the team.</li>
 *   <li>{@code totalRuns()}: sum of runs of all players (0 for an empty team).</li>
 *   <li>{@code topScorer()}: player with the most runs; on a tie, the one who joined first;
 *     null for an empty team.</li>
 * </ul>
 */
public class CricketTeam {

    private String name;
    private int maxPlayers;
    private final List<CricketPlayer> players = new ArrayList<>();

    public CricketTeam(String name, int maxPlayers) {
        // Your code here
    }

    public boolean addPlayer(CricketPlayer player) {
        // Your code here
        return false;
    }

    public List<CricketPlayer> getPlayers() {
        // Your code here
        return null;
    }

    public int totalRuns() {
        // Your code here
        return 0;
    }

    public CricketPlayer topScorer() {
        // Your code here
        return null;
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }
}
