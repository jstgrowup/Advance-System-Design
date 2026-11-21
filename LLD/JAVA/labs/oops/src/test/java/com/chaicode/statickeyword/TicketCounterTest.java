package com.chaicode.statickeyword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("static Keyword - Metro Token Machine")
class TicketCounterTest {

    @BeforeEach
    void resetNetwork() {
        TicketCounter.reset();
    }

    @Test
    void totalTokensFieldIsStaticButIssuedHereIsNot() throws Exception {
        int total = TicketCounter.class.getDeclaredField("totalTokens").getModifiers();
        int here = TicketCounter.class.getDeclaredField("issuedHere").getModifiers();
        assertTrue(Modifier.isStatic(total), "totalTokens must be static (one shared copy)");
        assertFalse(Modifier.isStatic(here), "issuedHere must stay an instance field");
    }

    @Nested
    @DisplayName("Creating machines")
    class Creating {

        @Test
        void storesTrimmedStationName() {
            TicketCounter machine = new TicketCounter("  Rajiv Chowk ");
            assertEquals("Rajiv Chowk", machine.getStationName());
            assertEquals(0, machine.getIssuedHere());
        }

        @Test
        void rejectsBlankStationName() {
            assertThrows(IllegalArgumentException.class, () -> new TicketCounter(" "));
            assertThrows(IllegalArgumentException.class, () -> new TicketCounter(null));
        }
    }

    @Nested
    @DisplayName("Issuing tokens")
    class Issuing {

        @Test
        void firstTokenIsMT0001() {
            TicketCounter machine = new TicketCounter("MG Road");
            assertEquals("MT-0001", machine.issueToken());
            assertEquals("MT-0002", machine.issueToken());
        }

        @Test
        void sequenceIsSharedAcrossMachines() {
            TicketCounter mgRoad = new TicketCounter("MG Road");
            TicketCounter majestic = new TicketCounter("Majestic");
            assertEquals("MT-0001", mgRoad.issueToken());
            assertEquals("MT-0002", majestic.issueToken());
            assertEquals("MT-0003", mgRoad.issueToken());
        }

        @Test
        void eachMachineCountsItsOwnTokens() {
            TicketCounter mgRoad = new TicketCounter("MG Road");
            TicketCounter majestic = new TicketCounter("Majestic");
            mgRoad.issueToken();
            mgRoad.issueToken();
            majestic.issueToken();
            assertEquals(2, mgRoad.getIssuedHere());
            assertEquals(1, majestic.getIssuedHere());
            assertEquals(3, TicketCounter.totalIssued());
        }

        @Test
        void paddingGrowsWithNumber() {
            TicketCounter machine = new TicketCounter("Indiranagar");
            String last = "";
            for (int i = 0; i < 12; i++) {
                last = machine.issueToken();
            }
            assertEquals("MT-0012", last);
        }
    }

    @Test
    void resetStartsNetworkAgain() {
        TicketCounter machine = new TicketCounter("MG Road");
        machine.issueToken();
        machine.issueToken();
        TicketCounter.reset();
        assertEquals(0, TicketCounter.totalIssued());
        assertEquals("MT-0001", new TicketCounter("Majestic").issueToken());
    }

    @Test
    void describeShowsLocalAndNetworkCounts() {
        TicketCounter rajivChowk = new TicketCounter("Rajiv Chowk");
        TicketCounter other = new TicketCounter("Kashmere Gate");
        rajivChowk.issueToken();
        rajivChowk.issueToken();
        other.issueToken();
        other.issueToken();
        other.issueToken();
        assertEquals("Rajiv Chowk | here: 2 | network: 5", rajivChowk.describe());
    }
}
