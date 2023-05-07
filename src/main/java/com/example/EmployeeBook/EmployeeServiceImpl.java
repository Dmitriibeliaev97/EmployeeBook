package com.example.EmployeeBook;

import com.example.EmployeeBook.Exceptions.EmployeeAlreadyAddedException;
import com.example.EmployeeBook.Exceptions.EmployeeNotFoundException;
import com.example.EmployeeBook.Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYEEBOOK_STORAGE_SIZE = 5;
    private final Map<String, Employee> employeeBook = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        if (employeeBook.size() == EMPLOYEEBOOK_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Хранилище полное");
        }
        employeeBook.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeeBook.values());
    }
}
