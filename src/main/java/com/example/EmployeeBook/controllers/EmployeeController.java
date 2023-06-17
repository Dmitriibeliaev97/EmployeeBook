package com.example.EmployeeBook.controllers;

import com.example.EmployeeBook.model.Employee;
import com.example.EmployeeBook.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam ("firstName") String firstName,
                                @RequestParam ("lastName") String lastName,
                                @RequestParam ("salary") Integer salary,
                                @RequestParam ("departmentId") Integer departmentId) {
        return employeeService.addEmployee(
                firstName,
                lastName,
                salary,
                departmentId);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam ("firstName") String firstName,
                                   @RequestParam ("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("firstName") String firstName,
                                 @RequestParam ("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Map<String, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
