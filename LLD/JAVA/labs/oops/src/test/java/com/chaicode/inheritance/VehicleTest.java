package com.chaicode.inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Inheritance - FleetGo Vehicles")
class VehicleTest {

    @Nested
    @DisplayName("Vehicle (parent)")
    class Parent {

        @Test
        void loadsWithinCapacity() {
            Vehicle van = new Vehicle("DL01VN0001", 100);
            assertTrue(van.load(60));
            assertTrue(van.load(40));
            assertEquals(100, van.getCurrentLoadKg());
            assertFalse(van.load(1));
            assertFalse(van.load(0));
            assertFalse(van.load(-5));
            assertEquals(100, van.getCurrentLoadKg());
        }

        @Test
        void describeAndUnload() {
            Vehicle van = new Vehicle("MH12AB1234", 100);
            van.load(30);
            assertEquals("MH12AB1234 | Load: 30/100 kg", van.describe());
            van.unloadAll();
            assertEquals(0, van.getCurrentLoadKg());
            assertEquals(4, van.wheels());
        }
    }

    @Nested
    @DisplayName("Bike")
    class BikeTests {

        @Test
        void constructorCallsSuper() {
            Bike bike = new Bike("MH12AB1234");
            assertEquals("MH12AB1234", bike.getRegistration());
            assertEquals(20, bike.getMaxLoadKg());
            assertEquals(0, bike.getCurrentLoadKg());
        }

        @Test
        void inheritsLoadRules() {
            Bike bike = new Bike("MH12AB1234");
            assertTrue(bike.load(15));
            assertFalse(bike.load(10));
            assertTrue(bike.load(5));
            assertEquals(20, bike.getCurrentLoadKg());
        }

        @Test
        void overridesWheelsAndDescribe() {
            Bike bike = new Bike("MH12AB1234");
            bike.load(5);
            assertEquals(2, bike.wheels());
            assertEquals("Bike | MH12AB1234 | Load: 5/20 kg", bike.describe());
        }
    }

    @Nested
    @DisplayName("Truck")
    class TruckTests {

        @Test
        void capacityComesFromAxles() {
            Truck truck = new Truck("KA01TR9999", 3);
            assertEquals("KA01TR9999", truck.getRegistration());
            assertEquals(3, truck.getAxles());
            assertEquals(15000, truck.getMaxLoadKg());
            assertEquals(12, truck.wheels());
        }

        @Test
        void describeReusesParent() {
            Truck truck = new Truck("KA01TR9999", 2);
            assertEquals("Truck | KA01TR9999 | Load: 0/10000 kg | Axles: 2", truck.describe());
            truck.load(7500);
            assertEquals("Truck | KA01TR9999 | Load: 7500/10000 kg | Axles: 2", truck.describe());
        }
    }

    @Test
    void wholeFleetIsAVehicle() {
        Vehicle[] fleet = {new Bike("B1"), new Truck("T1", 2), new Vehicle("V1", 500)};
        int totalCapacity = 0;
        int totalWheels = 0;
        for (Vehicle v : fleet) {
            assertTrue(v instanceof Vehicle);
            totalCapacity += v.getMaxLoadKg();
            totalWheels += v.wheels();
        }
        assertEquals(Vehicle.class, Bike.class.getSuperclass());
        assertEquals(Vehicle.class, Truck.class.getSuperclass());
        assertEquals(20 + 10000 + 500, totalCapacity);
        assertEquals(2 + 8 + 4, totalWheels);
    }
}
