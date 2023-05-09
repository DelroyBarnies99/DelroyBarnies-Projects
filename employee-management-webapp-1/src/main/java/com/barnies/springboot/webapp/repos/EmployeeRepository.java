package com.barnies.springboot.webapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barnies.springboot.webapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
