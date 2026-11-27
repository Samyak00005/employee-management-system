
package com.samyak.employee_management_system.service;

import com.samyak.employee_management_system.entity.Employee;
import com.samyak.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. Add Employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // 2. Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 3. Get Employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // 4. Update Employee
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee =
                employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {

            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmailId(employee.getEmailId());

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }

    // 5. Delete Employee
    public String deleteEmployee(Long id) {

        employeeRepository.deleteById(id);

        return "Employee with id: " + id + " has been deleted";
    }
}
