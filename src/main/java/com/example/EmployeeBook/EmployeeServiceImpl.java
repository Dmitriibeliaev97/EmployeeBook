package com.example.EmployeeBook;

import com.example.EmployeeBook.Exceptions.EmployeeAlreadyAddedException;
import com.example.EmployeeBook.Exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeBook;

    public EmployeeServiceImpl() {
        this.employeeBook = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
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
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Collection<Employee> findAll() { return Collections.unmodifiableCollection(employeeBook.values());
    }
}
