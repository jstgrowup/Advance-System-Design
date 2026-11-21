package com.chaicode.records;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Records - WeatherWise Sensors")
class TemperatureReadingTest {

    @Test
    void isARecordWithThreeComponents() {
        assertTrue(TemperatureReading.class.isRecord());
        List<String> names = Arrays.stream(TemperatureReading.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toList();
        assertEquals(List.of("sensorId", "city", "celsius"), names);
    }

    @Nested
    @DisplayName("Compact constructor")
    class CompactConstructor {

        @Test
        void roundsCelsiusToOneDecimal() {
            TemperatureReading reading = new TemperatureReading("WW-101", "Nagpur", 36.66);
            assertEquals(36.7, reading.celsius(), 0.0001);
            assertEquals("WW-101", reading.sensorId());
            assertEquals("Nagpur", reading.city());
        }

        @Test
        void rejectsMissingSensorOrCity() {
            assertThrows(IllegalArgumentException.class, () -> new TemperatureReading(null, "Pune", 30));
            assertThrows(IllegalArgumentException.class, () -> new TemperatureReading("  ", "Pune", 30));
            assertThrows(IllegalArgumentException.class, () -> new TemperatureReading("WW-1", "", 30));
            assertThrows(IllegalArgumentException.class, () -> new TemperatureReading("WW-1", null, 30));
        }

        @Test
        void rejectsImpossibleTemperatures() {
            assertThrows(IllegalArgumentException.class, () -> new TemperatureReading("WW-1", "Leh", -90.5));
            assertThrows(IllegalArgumentException.class, () -> new TemperatureReading("WW-1", "Churu", 61));
            assertEquals(60.0, new TemperatureReading("WW-1", "Churu", 60).celsius(), 0.0001);
            assertEquals(-90.0, new TemperatureReading("WW-1", "Leh", -90).celsius(), 0.0001);
        }
    }

    @Nested
    @DisplayName("Factory & derived values")
    class Derived {

        @Test
        void fromFahrenheitFactory() {
            assertEquals(40.0, TemperatureReading.fromFahrenheit("WW-7", "Delhi", 104).celsius(), 0.0001);
            TemperatureReading fever = TemperatureReading.fromFahrenheit("WW-8", "Mumbai", 98.6);
            assertEquals(new TemperatureReading("WW-8", "Mumbai", 37.0), fever);
        }

        @Test
        void toFahrenheitAndHeatwave() {
            assertEquals(97.9, new TemperatureReading("WW-2", "Kochi", 36.6).toFahrenheit(), 0.0001);
            assertEquals(104.0, new TemperatureReading("WW-3", "Delhi", 40).toFahrenheit(), 0.0001);
            assertTrue(new TemperatureReading("WW-3", "Delhi", 39.96).isHeatwave());
            assertFalse(new TemperatureReading("WW-4", "Shimla", 39.9).isHeatwave());
        }
    }

    @Nested
    @DisplayName("withCelsius()")
    class WithCelsius {

        @Test
        void returnsNewReadingAndKeepsOriginal() {
            TemperatureReading morning = new TemperatureReading("WW-5", "Jaipur", 31.2);
            TemperatureReading noon = morning.withCelsius(42.44);
            assertNotSame(morning, noon);
            assertEquals(31.2, morning.celsius(), 0.0001);
            assertEquals(new TemperatureReading("WW-5", "Jaipur", 42.4), noon);
            assertNotEquals(morning, noon);
        }

        @Test
        void stillValidates() {
            TemperatureReading reading = new TemperatureReading("WW-6", "Chennai", 33);
            assertThrows(IllegalArgumentException.class, () -> reading.withCelsius(75));
        }
    }
}
