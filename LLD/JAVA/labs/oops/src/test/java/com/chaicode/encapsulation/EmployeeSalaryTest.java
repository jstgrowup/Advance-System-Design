package com.chaicode.encapsulation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Encapsulation - TechCorp Payroll")
class EmployeeSalaryTest {

    @Nested
    @DisplayName("Data hiding")
    class DataHiding {

        @Test
        void fieldsArePrivate() throws NoSuchFieldException {
            for (String name : new String[]{"name", "salary", "pin"}) {
                int mods = EmployeeSalary.class.getDeclaredField(name).getModifiers();
                assertTrue(Modifier.isPrivate(mods), name + " must be private");
            }
        }

        @Test
        void pinIsWriteOnlyAndSalaryHasNoSetter() {
            boolean forbidden = Arrays.stream(EmployeeSalary.class.getDeclaredMethods())
                    .map(Method::getName)
                    .anyMatch(n -> n.equals("getPin") || n.equals("setSalary"));
            assertFalse(forbidden, "no getPin() and no setSalary() allowed");
        }
    }

    @Nested
    @DisplayName("Constructor")
    class Constructor {

        @Test
        void storesNameAndSalary() {
            EmployeeSalary emp = new EmployeeSalary("Neha", 50000);
            assertEquals("Neha", emp.getName());
            assertEquals(50000.0, emp.getSalary(), 0.001);
        }

        @Test
        void rejectsNonPositiveSalary() {
            assertThrows(IllegalArgumentException.class, () -> new EmployeeSalary("Neha", 0));
            assertThrows(IllegalArgumentException.class, () -> new EmployeeSalary("Neha", -1000));
        }
    }

    @Nested
    @DisplayName("raise()")
    class Raise {

        @Test
        void increasesSalaryByPercent() {
            EmployeeSalary emp = new EmployeeSalary("Neha", 50000);
            emp.raise(10);
            assertEquals(55000.0, emp.getSalary(), 0.001);
            emp.raise(30);
            assertEquals(71500.0, emp.getSalary(), 0.001);
        }

        @Test
        void roundsToTwoDecimals() {
            EmployeeSalary emp = new EmployeeSalary("Neha", 33333.33);
            emp.raise(7);
            assertEquals(35666.66, emp.getSalary(), 0.0001);
        }

        @Test
        void rejectsInvalidPercentAndKeepsSalary() {
            EmployeeSalary emp = new EmployeeSalary("Neha", 40000);
            assertThrows(IllegalArgumentException.class, () -> emp.raise(0));
            assertThrows(IllegalArgumentException.class, () -> emp.raise(-5));
            assertThrows(IllegalArgumentException.class, () -> emp.raise(30.5));
            assertEquals(40000.0, emp.getSalary(), 0.001);
        }
    }

    @Nested
    @DisplayName("PIN")
    class Pin {

        @Test
        void verifiesCorrectPinOnly() {
            EmployeeSalary emp = new EmployeeSalary("Neha", 40000);
            emp.setPin("4321");
            assertTrue(emp.verifyPin("4321"));
            assertFalse(emp.verifyPin("1234"));
            emp.setPin("0007");
            assertTrue(emp.verifyPin("0007"));
            assertFalse(emp.verifyPin("4321"));
        }

        @Test
        void invalidPinsRejectedAndUnsetPinNeverVerifies() {
            EmployeeSalary emp = new EmployeeSalary("Neha", 40000);
            assertFalse(emp.verifyPin(null));
            assertFalse(emp.verifyPin("0000"));
            assertThrows(IllegalArgumentException.class, () -> emp.setPin(null));
            assertThrows(IllegalArgumentException.class, () -> emp.setPin("12"));
            assertThrows(IllegalArgumentException.class, () -> emp.setPin("12345"));
            assertThrows(IllegalArgumentException.class, () -> emp.setPin("12a4"));
        }
    }
}
