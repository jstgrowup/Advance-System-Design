package com.chaicode.thiskeyword;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("this Keyword - Gully Cricket League")
class CricketTeamTest {

    @Nested
    @DisplayName("Shadowed fields need this")
    class ShadowedFields {

        @Test
        void constructorsStoreParameters() {
            CricketPlayer player = new CricketPlayer("Chintu", 42);
            CricketTeam team = new CricketTeam("Sector 7 Strikers", 6);
            assertEquals("Chintu", player.getName());
            assertEquals(42, player.getRuns());
            assertEquals("Sector 7 Strikers", team.getName());
            assertEquals(6, team.getMaxPlayers());
        }

        @Test
        void addRunsUpdatesThisPlayer() {
            CricketPlayer player = new CricketPlayer("Chintu", 10);
            player.addRuns(25);
            player.addRuns(0);
            player.addRuns(-4);
            assertEquals(35, player.getRuns());
        }
    }

    @Nested
    @DisplayName("joinTeam() passes this")
    class JoinTeam {

        @Test
        void teamHoldsTheSamePlayerObject() {
            CricketTeam team = new CricketTeam("Sector 7 Strikers", 6);
            CricketPlayer chintu = new CricketPlayer("Chintu", 10);
            assertTrue(chintu.joinTeam(team));
            assertEquals(1, team.getPlayers().size());
            assertSame(chintu, team.getPlayers().get(0));
            assertSame(team, chintu.getTeam());
        }

        @Test
        void cannotJoinTwoTeamsOrNull() {
            CricketTeam strikers = new CricketTeam("Sector 7 Strikers", 6);
            CricketTeam titans = new CricketTeam("Gali No. 3 Titans", 6);
            CricketPlayer pinky = new CricketPlayer("Pinky", 5);
            assertFalse(pinky.joinTeam(null));
            assertTrue(pinky.joinTeam(strikers));
            assertFalse(pinky.joinTeam(titans));
            assertFalse(pinky.joinTeam(strikers));
            assertSame(strikers, pinky.getTeam());
            assertEquals(0, titans.getPlayers().size());
            assertEquals(1, strikers.getPlayers().size());
        }

        @Test
        void fullTeamRejectsPlayerWhoStaysTeamless() {
            CricketTeam team = new CricketTeam("Tiny XI", 2);
            assertTrue(new CricketPlayer("A", 1).joinTeam(team));
            assertTrue(new CricketPlayer("B", 2).joinTeam(team));
            CricketPlayer late = new CricketPlayer("Late Lalit", 3);
            assertFalse(late.joinTeam(team));
            assertNull(late.getTeam());
            assertEquals(2, team.getPlayers().size());
        }
    }

    @Nested
    @DisplayName("CricketTeam")
    class Team {

        @Test
        void addPlayerRejectsNullAndDuplicates() {
            CricketTeam team = new CricketTeam("Sector 7 Strikers", 6);
            CricketPlayer chintu = new CricketPlayer("Chintu", 10);
            assertFalse(team.addPlayer(null));
            assertTrue(team.addPlayer(chintu));
            assertFalse(team.addPlayer(chintu));
            assertEquals(1, team.getPlayers().size());
        }

        @Test
        void getPlayersReturnsCopy() {
            CricketTeam team = new CricketTeam("Sector 7 Strikers", 6);
            new CricketPlayer("Chintu", 10).joinTeam(team);
            List<CricketPlayer> copy = team.getPlayers();
            copy.clear();
            assertEquals(1, team.getPlayers().size());
        }

        @Test
        void totalRunsAndTopScorer() {
            CricketTeam team = new CricketTeam("Sector 7 Strikers", 6);
            assertEquals(0, team.totalRuns());
            assertNull(team.topScorer());
            CricketPlayer chintu = new CricketPlayer("Chintu", 30);
            CricketPlayer pinky = new CricketPlayer("Pinky", 45);
            CricketPlayer golu = new CricketPlayer("Golu", 45);
            chintu.joinTeam(team);
            pinky.joinTeam(team);
            golu.joinTeam(team);
            chintu.addRuns(5);
            assertEquals(125, team.totalRuns());
            assertSame(pinky, team.topScorer());
        }
    }
}
