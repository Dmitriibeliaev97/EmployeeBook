package com.example.EmployeeBook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping
    public String findAll (){
        return service.findAll().toString();
    }


}
