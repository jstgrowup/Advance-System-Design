package com.chaicode.classesobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Classes & Objects - ChaiRides Car")
class CarTest {

    private static Car newCar(String brand, String color) {
        Car car = new Car();
        car.brand = brand;
        car.color = color;
        return car;
    }

    @Nested
    @DisplayName("Object state")
    class ObjectState {

        @Test
        void newCarHasDefaultValues() {
            Car car = new Car();
            assertNull(car.brand);
            assertEquals(0, car.fuelLevel);
        }

        @Test
        void eachObjectHasItsOwnState() {
            Car car1 = newCar("Tata", "Red");
            Car car2 = newCar("Mahindra", "Black");
            car1.refuel(10);
            assertEquals(10, car1.fuelLevel);
            assertEquals(0, car2.fuelLevel);
        }

        @Test
        void twoReferencesSameObject() {
            Car car1 = newCar("Tata", "Red");
            Car sameCar = car1;
            sameCar.refuel(5);
            assertSame(car1, sameCar);
            assertEquals(5, car1.fuelLevel);
        }
    }

    @Nested
    @DisplayName("refuel()")
    class Refuel {

        @Test
        void addsFuel() {
            Car car = newCar("Tata", "Red");
            car.refuel(12);
            car.refuel(3);
            assertEquals(15, car.fuelLevel);
        }

        @Test
        void capsAtTankCapacity() {
            Car car = newCar("Tata", "Red");
            car.refuel(35);
            car.refuel(20);
            assertEquals(Car.TANK_CAPACITY, car.fuelLevel);
        }

        @Test
        void ignoresNonPositive() {
            Car car = newCar("Tata", "Red");
            car.refuel(10);
            car.refuel(-5);
            car.refuel(0);
            assertEquals(10, car.fuelLevel);
        }
    }

    @Nested
    @DisplayName("drive()")
    class Drive {

        @Test
        void usesOneLitrePerTenKm() {
            Car car = newCar("Tata", "Red");
            car.refuel(10);
            assertTrue(car.drive(45));
            assertEquals(6, car.fuelLevel);
        }

        @Test
        void notEnoughFuel() {
            Car car = newCar("Tata", "Red");
            car.refuel(2);
            assertFalse(car.drive(50));
            assertEquals(2, car.fuelLevel);
        }

        @Test
        void invalidDistance() {
            Car car = newCar("Tata", "Red");
            car.refuel(5);
            assertFalse(car.drive(0));
            assertFalse(car.drive(-10));
            assertEquals(5, car.fuelLevel);
        }
    }

    @Test
    void describe() {
        Car car = newCar("Tata", "Red");
        car.refuel(12);
        assertEquals("Red Tata | Fuel: 12L", car.describe());
    }
}
