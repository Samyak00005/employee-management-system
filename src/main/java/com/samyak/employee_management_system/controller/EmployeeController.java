package com.samyak.employee_management_system.controller;

import com.samyak.employee_management_system.entity.Employee;
import com.samyak.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // @query paramter, @requestParam (paramter)

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. Post: Add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee)// Request Body so we want through body and not header(url)
    {
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
    @DeleteMapping("/{id}")//Handles HTTP DELETE requests. Used to delete an employee using their ID.
    public String deleteEmployee(@PathVariable Long id)
    // @PathVariable: Extracts the employee ID from the URL.
    {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully!";
    }


}
