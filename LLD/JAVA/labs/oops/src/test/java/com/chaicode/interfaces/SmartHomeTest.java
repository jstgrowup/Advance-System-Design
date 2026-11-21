package com.chaicode.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Interfaces - ChaiHome Automation")
class SmartHomeTest {

    @Nested
    @DisplayName("Dimmable static method")
    class Clamp {

        @Test
        void clampKeepsLevelInRange() {
            assertEquals(100, Dimmable.clamp(150));
            assertEquals(0, Dimmable.clamp(-5));
            assertEquals(40, Dimmable.clamp(40));
            assertEquals(Dimmable.MAX_LEVEL, Dimmable.clamp(Dimmable.MAX_LEVEL));
        }
    }

    @Nested
    @DisplayName("SmartLight")
    class Light {

        @Test
        void newLightIsOffAtFullBrightness() {
            SmartLight light = new SmartLight("Hall Light");
            assertEquals("Hall Light", light.getName());
            assertFalse(light.isOn());
            assertEquals(100, light.getBrightness());
            light.turnOn();
            assertTrue(light.isOn());
            light.turnOff();
            assertFalse(light.isOn());
        }

        @Test
        void setBrightnessClampsAndZeroSwitchesOff() {
            SmartLight light = new SmartLight("Hall Light");
            light.turnOn();
            light.setBrightness(250);
            assertEquals(100, light.getBrightness());
            light.setBrightness(0);
            assertEquals(0, light.getBrightness());
            assertFalse(light.isOn());
            light.turnOn();
            assertEquals(100, light.getBrightness());
        }

        @Test
        void lightOverridesDefaultStatus() {
            SmartLight light = new SmartLight("Hall Light");
            assertEquals("Hall Light is OFF", light.status());
            light.turnOn();
            light.setBrightness(60);
            assertEquals("Hall Light is ON at 60%", light.status());
            assertDoesNotThrow(() -> SmartLight.class.getDeclaredMethod("status"));
        }
    }

    @Nested
    @DisplayName("SmartFan")
    class Fan {

        @Test
        void fanUsesDefaultStatus() {
            SmartFan fan = new SmartFan("Bedroom Fan");
            assertEquals("Bedroom Fan is OFF", fan.status());
            fan.turnOn();
            assertEquals("Bedroom Fan is ON", fan.status());
            assertThrows(NoSuchMethodException.class, () -> SmartFan.class.getDeclaredMethod("status"));
        }
    }

    @Nested
    @DisplayName("SmartHome controller")
    class Hub {

        @Test
        void countOnAndTurnAllOff() {
            SmartHome home = new SmartHome();
            SmartLight light = new SmartLight("Hall Light");
            SmartFan fan = new SmartFan("Bedroom Fan");
            SmartFan kitchenFan = new SmartFan("Kitchen Fan");
            home.addDevice(light);
            home.addDevice(fan);
            home.addDevice(kitchenFan);
            light.turnOn();
            kitchenFan.turnOn();
            assertEquals(2, home.countOn());
            home.turnAllOff();
            assertEquals(0, home.countOn());
            assertFalse(light.isOn());
            assertFalse(kitchenFan.isOn());
        }

        @Test
        void statusReportKeepsOrderAndIgnoresNull() {
            SmartHome home = new SmartHome();
            SmartLight light = new SmartLight("Hall Light");
            light.turnOn();
            light.setBrightness(60);
            home.addDevice(light);
            home.addDevice(null);
            home.addDevice(new SmartFan("Bedroom Fan"));
            assertEquals(List.of("Hall Light is ON at 60%", "Bedroom Fan is OFF"), home.statusReport());
        }

        @Test
        void emptyHome() {
            SmartHome home = new SmartHome();
            assertEquals(0, home.countOn());
            assertEquals(List.of(), home.statusReport());
        }
    }
}
