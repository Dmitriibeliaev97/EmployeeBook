package com.example.EmployeeBook.service.impl;

import com.example.EmployeeBook.Exceptions.EmployeeAlreadyAddedException;
import com.example.EmployeeBook.Exceptions.EmployeeNotFoundException;
import com.example.EmployeeBook.Exceptions.EmployeeStorageIsFullException;
import com.example.EmployeeBook.Exceptions.InvalidInputException;
import com.example.EmployeeBook.model.Employee;
import com.example.EmployeeBook.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYEEBOOK_STORAGE_SIZE = 5;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        validateInput(firstName, lastName);
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        if (employees.size() == EMPLOYEEBOOK_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Хранилище полное");
        }
        employees.put(employeeKey, new Employee(firstName, lastName, salary, department));
        return employees.get(employeeKey);
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        validateInput(firstName, lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.remove(employeeKey);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        validateInput(firstName, lastName);
        if (!employees.containsKey(getEmployeeKey(firstName, lastName))) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.get(employeeKey);
    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return employees;
    }

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    private void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName)) && (isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }
}
