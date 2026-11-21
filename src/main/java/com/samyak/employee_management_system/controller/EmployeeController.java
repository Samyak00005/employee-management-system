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

    // 1. Post: Add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // 2. GET: Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Returning all Data from Database to client/browser
    }

    // 3. GET: Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // 4. PUT: Update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    // 5. DELETE: Delete employee by ID
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully!";
    }

    // @DeleteMapping("/{id}"): Handles HTTP DELETE requests. Used to delete an employee using their ID.
    // @PathVariable: Extracts the employee ID from the URL.
    // deleteById(): Deletes the employee record matching the given ID.

}
