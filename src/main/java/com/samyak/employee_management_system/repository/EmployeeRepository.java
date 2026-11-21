package com.samyak.employee_management_system.repository;

import com.samyak.employee_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // All CRUD databases entities are here made by JPA repository
}
