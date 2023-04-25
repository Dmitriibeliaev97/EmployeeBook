package com.example.EmployeeBook;

import com.example.EmployeeBook.Exceptions.EmployeeAlreadyAddedException;
import com.example.EmployeeBook.Exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeBook;

    public EmployeeServiceImpl() {
        this.employeeBook = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeBook.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.contains(employee)) {
            employeeBook.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findeAll() {
        return Collections.unmodifiableList(employeeBook);
    }

}
