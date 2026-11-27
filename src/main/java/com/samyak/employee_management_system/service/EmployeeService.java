package com.samyak.employee_management_system.service;

import com.samyak.employee_management_system.entity.Employee;
import com.samyak.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. Add Employee
    public employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // 2. Get All Employees
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    // 3. Get Employee by ID
    public Employee getEmployee(int id) {
        return EmployeeRepository.findById(id).orElse(null);
        // Find this(id) employee and send or null if not found.
    }

    // 4. Update Employee
    public Employee updateEmployee(Long id, Employee employee) {
        // Find the employee details and store in existingEmployee
        Employee existingEmployee = employee.findById(id).orElse(null);

        if (existingEmployee != null) {
            // set employee from  existingEmployee.
            existingEmployee.setFirstName(
                    employee.getFirstName()
            );
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmailId(employee.getEmailId());

            // Save the new data and send the object.
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    // 5. Delete Employee
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(employee);
        return "Employee with id: " + id + " has been deleted";
    }
}
