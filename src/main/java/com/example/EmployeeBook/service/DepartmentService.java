package com.example.EmployeeBook.service;

import com.example.EmployeeBook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> getAllEmployeesByDepartment(Integer departmentId);
    Integer getSumSalary(Integer departmentId);
    Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);
    Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(Integer departmentId);
}
