package com.chaicode.statickeyword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("static Keyword - ChaiCode App Settings")
class AppConfigTest {

    @BeforeEach
    void restoreDefaults() {
        AppConfig.reset();
    }

    @Nested
    @DisplayName("Static settings map")
    class Settings {

        @Test
        void defaultsLoadedWithoutCreatingObjects() {
            assertEquals("ChaiCode", AppConfig.get("app.name"));
            assertEquals("dark", AppConfig.get("app.theme"));
            assertEquals("2.4.1", AppConfig.get("app.version"));
        }

        @Test
        void unknownOrNullKeyThrows() {
            assertThrows(IllegalArgumentException.class, () -> AppConfig.get("app.colour"));
            assertThrows(IllegalArgumentException.class, () -> AppConfig.get(null));
        }

        @Test
        void getOrDefaultFallsBack() {
            assertEquals("en", AppConfig.getOrDefault("app.language", "en"));
            assertEquals("en", AppConfig.getOrDefault(null, "en"));
            assertEquals("dark", AppConfig.getOrDefault("app.theme", "light"));
        }

        @Test
        void getIntParsesNumbers() {
            assertEquals(25, AppConfig.getInt("max.upload.mb"));
            assertThrows(IllegalArgumentException.class, () -> AppConfig.getInt("app.theme"));
            assertThrows(IllegalArgumentException.class, () -> AppConfig.getInt("missing"));
        }

        @Test
        void setOverridesAndResetRestoresDefaults() {
            AppConfig.set("app.theme", "light");
            AppConfig.set("beta.features", "on");
            assertEquals("light", AppConfig.get("app.theme"));
            assertEquals("on", AppConfig.get("beta.features"));

            AppConfig.reset();
            assertEquals("dark", AppConfig.get("app.theme"));
            assertThrows(IllegalArgumentException.class, () -> AppConfig.get("beta.features"));

            assertThrows(IllegalArgumentException.class, () -> AppConfig.set(" ", "x"));
            assertThrows(IllegalArgumentException.class, () -> AppConfig.set("app.theme", null));
        }
    }

    @Nested
    @DisplayName("Static nested Version")
    class VersionTests {

        @Test
        void parsesThreeParts() {
            AppConfig.Version v = new AppConfig.Version("2.10.3");
            assertEquals(2, v.getMajor());
            assertEquals(10, v.getMinor());
            assertEquals(3, v.getPatch());
            assertEquals("v2.10.3", v.toString());
        }

        @Test
        void rejectsBadText() {
            for (String bad : new String[] {"2.4", "2.x.1", "1.-2.3", "1.2.3.4", ""}) {
                assertThrows(IllegalArgumentException.class, () -> new AppConfig.Version(bad), bad);
            }
            assertThrows(IllegalArgumentException.class, () -> new AppConfig.Version(null));
        }

        @Test
        void comparesNumerically() {
            AppConfig.Version newer = new AppConfig.Version("2.10.0");
            AppConfig.Version older = new AppConfig.Version("2.9.9");
            assertTrue(newer.compareTo(older) > 0);
            assertTrue(older.compareTo(newer) < 0);
            assertEquals(0, new AppConfig.Version("1.2.3").compareTo(new AppConfig.Version("1.2.3")));
            assertTrue(newer.isNewerThan(older));
            assertFalse(older.isNewerThan(newer));
            assertTrue(new AppConfig.Version("3.0.0").isNewerThan(new AppConfig.Version("2.99.99")));
        }

        @Test
        void currentVersionReadsSetting() {
            assertEquals("v2.4.1", AppConfig.currentVersion().toString());
            AppConfig.set("app.version", "3.0.0");
            assertEquals("v3.0.0", AppConfig.currentVersion().toString());
        }
    }
}
