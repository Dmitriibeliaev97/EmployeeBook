package com.example.EmployeeBook.controllers;

import com.example.EmployeeBook.model.Employee;
import com.example.EmployeeBook.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment (@PathVariable("id") Integer departmentId) {
        return departmentService.getAllEmployeesByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public Integer getSumSalary(@PathVariable("id") Integer departmentId) {
        return departmentService.getSumSalary(departmentId);
    }
    @GetMapping("/{id}/salary/max")
    public Employee getEmployeeWithMaxSalary(@PathVariable("id") Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public Employee getEmployeeWithMinSalary(@PathVariable ("id") Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(@RequestParam(name = "departmentId", required = false) Integer departmentId) {
        return departmentService.getGroupedByDepartmentEmployees(departmentId);
    }
}
