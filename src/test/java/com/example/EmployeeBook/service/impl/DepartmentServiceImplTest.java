package com.example.EmployeeBook.service.impl;

import com.example.EmployeeBook.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.CloseableThreadContext.put;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final List<Employee> employees = new ArrayList<>() {{
        add(new Employee("Dmitrii", "Beliaev", 150000, 1));
        add(new Employee("Anatolii", "Borisov", 120000, 1));
        add(new Employee("Viktoriia", "Kaneva", 110000, 1));
    }};

    @Test
    void shouldGetAllEmployeesByDepartment() {
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);

        Map<Integer, List<Employee>> allEmployeesByDepartment = departmentService.getAllEmployeesByDepartment(departmentId);

        assertEquals(employeeMap.values().stream().filter(employee -> employee.getDepartment().
                equals(departmentId)).collect(Collectors.groupingBy(Employee::getDepartment)), allEmployeesByDepartment);

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void getSumSalary() {
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);

        Integer employeeSumSalary = departmentService.getSumSalary(departmentId);

        assertEquals(380000, employeeSumSalary);

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void shouldGetEmployeeWithMaxSalary() {
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);

        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);

        assertEquals(employees.get(0), employeeWithMaxSalary);

        verify(employeeService, times(1)).getAllEmployees();

    }

    @Test
    void shouldReturnNullWhenNoEmployeesInDepartment() {
        final int departmentId = 2;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);

        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);
        Employee employeeWithMinSalary = departmentService.getEmployeeWithMinSalary(departmentId);

        assertNull(employeeWithMaxSalary);
        assertNull(employeeWithMinSalary);

        verify(employeeService, times(2)).getAllEmployees();
    }

    @Test
    void shouldGetEmployeeWithMinSalary() {
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);

        Employee employeeWithMinSalary = departmentService.getEmployeeWithMinSalary(departmentId);

        assertEquals(employees.get(2), employeeWithMinSalary);

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void shouldGetGroupedByDepartmentEmployees() {
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);

        Map<Integer, List<Employee>> groupedByDepartmentEmployees = departmentService.getGroupedByDepartmentEmployees(departmentId);

        assertEquals(employeeMap.values().stream().filter(employee -> employee.getDepartment().
                equals(departmentId)).collect(Collectors.groupingBy(Employee::getDepartment)),
                groupedByDepartmentEmployees);

        verify(employeeService, times(1)).getAllEmployees();
    }
}