package com.samyak.employee_management_system.controller;

import com.samyak.employee_management_system.entity.Employee;
import com.samyak.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. GET: Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Returning all Data from Database to client/browser
    }

    // 2. Post: Add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

}
