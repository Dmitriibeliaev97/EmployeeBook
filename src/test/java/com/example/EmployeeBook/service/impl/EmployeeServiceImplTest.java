package com.example.EmployeeBook.service.impl;

import com.example.EmployeeBook.model.Employee;
import com.example.EmployeeBook.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceImplTest {
    private Employee employeeDmitrii;
    private Employee employeeViktoria;
    private Employee employeeLubov;
    private Employee employeeAnatolii;
    private EmployeeServiceImpl employees;

    @BeforeEach
    public void setUp() {
        employeeDmitrii = new Employee("Dmitrii", "Beliaev", 150000, 1);
        employeeViktoria = new Employee("Viktoria", "Kaneva", 125000, 1);
        employeeLubov = new Employee("Lubov", "Beliaeva", 105000, 2);
        employeeAnatolii = new Employee("Anatolii", "Borisov", 115000, 2);

        employees = new EmployeeServiceImpl();
        employees.addEmployee("Dmitrii", "Beliaev", 150000, 1);
        employees.addEmployee("Viktoria", "Kaneva", 125000, 1);
        employees.addEmployee("Lubov", "Beliaeva", 105000, 2);
        employees.addEmployee("Anatolii", "Borisov", 115000, 2);
    }


    @Test
    void addEmployee() {
        Employee expected = employees.addEmployee("Ivan", "Ivanov", 100000, 3);

        Employee actual = new Employee("Ivan", "Ivanov", 100000, 3);

        assertEquals(expected, actual);

    }

    @Test
    void removeEmployee() {
        Employee expected = employees.removeEmployee("Dmitrii", "Beliaev");

        Employee actual = new Employee("Dmitrii", "Beliaev", 150000, 1);

        assertEquals(expected, actual);
    }

    @Test
    void findEmployee() {
        Employee expected = employees.findEmployee("Dmitrii", "Beliaev");

        Employee actual = new Employee("Dmitrii", "Beliaev", 150000, 1);

        assertEquals(expected, actual);
    }

    @Test
    void getAllEmployees() {
        Map<String, Employee> expected = employees.getAllEmployees();

        Map<String, Employee> actual = new HashMap<>();
        actual.put("Dmitrii Beliaev", employeeDmitrii);
        actual.put("Viktoria Kaneva", employeeViktoria);
        actual.put("Lubov Beliaeva", employeeLubov);
        actual.put("Anatolii Borisov", employeeAnatolii);

        assertEquals(expected, actual);
    }
}