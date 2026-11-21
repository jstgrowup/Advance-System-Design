package com.chaicode.inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Inheritance - TechCorp HR")
class EmployeeTest {

    @Nested
    @DisplayName("Employee (parent)")
    class Parent {

        @Test
        void payIncludesAllowance() {
            Employee ravi = new Employee("Ravi", 40000);
            assertEquals("Ravi", ravi.getName());
            assertEquals(40000.0, ravi.getBaseSalary(), 0.001);
            assertEquals(42000.0, ravi.monthlyPay(), 0.001);
            assertEquals("Employee", ravi.role());
        }

        @Test
        void payslipFormat() {
            assertEquals("Employee Ravi: Rs. 42000.00", new Employee("Ravi", 40000).payslip());
        }
    }

    @Nested
    @DisplayName("Manager")
    class ManagerTests {

        @Test
        void constructorCallsSuper() {
            Manager asha = new Manager("Asha", 60000, 4);
            assertEquals("Asha", asha.getName());
            assertEquals(60000.0, asha.getBaseSalary(), 0.001);
            assertEquals(4, asha.getTeamSize());
            assertEquals("Manager", asha.role());
        }

        @Test
        void payBuildsOnSuperMonthlyPay() {
            assertEquals(68000.0, new Manager("Asha", 60000, 4).monthlyPay(), 0.001);
            assertEquals(62000.0, new Manager("Vikram", 60000, 0).monthlyPay(), 0.001);
        }

        @Test
        void rejectsNegativeTeamSize() {
            assertThrows(IllegalArgumentException.class, () -> new Manager("Asha", 60000, -1));
            assertDoesNotThrow(() -> new Manager("Asha", 60000, 0));
        }
    }

    @Test
    void internGetsStipendOnly() {
        Intern kabir = new Intern("Kabir", 15000);
        assertEquals("Kabir", kabir.getName());
        assertEquals(15000.0, kabir.monthlyPay(), 0.001);
        assertEquals("Intern", kabir.role());
    }

    @Test
    void parentReferenceUsesOverriddenMethods() {
        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Ravi", 40000));
        staff.add(new Manager("Asha", 60000, 4));
        staff.add(new Intern("Kabir", 15000));

        List<String> slips = new ArrayList<>();
        for (Employee e : staff) {
            slips.add(e.payslip());
        }
        assertEquals(List.of(
                "Employee Ravi: Rs. 42000.00",
                "Manager Asha: Rs. 68000.00",
                "Intern Kabir: Rs. 15000.00"), slips);
    }

    @Test
    void hierarchyAndOverridesDeclared() throws NoSuchMethodException {
        assertEquals(Employee.class, Manager.class.getSuperclass());
        assertEquals(Employee.class, Intern.class.getSuperclass());
        assertEquals(Manager.class, Manager.class.getDeclaredMethod("monthlyPay").getDeclaringClass());
        assertEquals(Intern.class, Intern.class.getDeclaredMethod("monthlyPay").getDeclaringClass());
    }
}
