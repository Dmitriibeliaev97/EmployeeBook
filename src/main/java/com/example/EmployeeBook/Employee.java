package com.example.EmployeeBook;

import java.util.List;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String surName;


    public Employee(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }
    public List<Employee> employeeBook = List.of(
            new Employee("Dmitrii", "Beliaev"),
            new Employee("Alexandr", "Rubanov"),
            new Employee("Pavel", "Bazhura"),
            new Employee("Vladislav", "Antonov"),
            new Employee("Viktoria", "Kaneva"),
            new Employee("Ekaterina", "Matveeva"),
            new Employee("Svetlana", "Shirokova"),
            new Employee("Elena", "Seitz"),
            new Employee("Tatiana", "Urisman"),
            new Employee("Natalia", "Zernova")
    );
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(surName, employee.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surName);
    }

    @Override
    public String toString() {
        return " Ф.И.О: " + firstName + " " + surName;
    }
}
