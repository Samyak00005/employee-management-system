
package com.samyak.employee_management_system.service;

import com.samyak.employee_management_system.entity.Employee;
import com.samyak.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. Add Employee
    public Employee addEmployee(Employee employee) {
        // Save method is from Repository extended JPA
        return employeeRepository.save(employee);
    }

    // 2. Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 3. Get Employee by ID
    public Employee getEmployeeById(Long id) {
        // Finding ID by findById method and passing id no. and Else if nothing is found.
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Employee not found!"
                        ));
    }

    // 4. Update Employee
    public Employee updateEmployee(Long id, Employee employee) {

        // find the employee by id and store it to update.
        Employee existingEmployee =
                employeeRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Employee Not Found"
                        ));

        // if we found the Id IT Will insert this block else null
        //       if (existingEmployee != null) { // --- No need of If and return null we using throw exception
        // Updating the values  (firstname, lastname, emailId)
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmailId(employee.getEmailId());

        // Returning updated Employee data
        return employeeRepository.save(existingEmployee);
        //}       return null;
    }

    // 5. Delete Employee
    public String deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Employee Not Found!!!"
            );
        } else {
            employeeRepository.deleteById(id);
            return "Employee with id: " + id + " has been deleted";
        }
    }
}
