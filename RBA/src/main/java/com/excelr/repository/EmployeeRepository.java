package com.excelr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmpId(String empId);
    Optional<Employee> findById(Long id);
    Optional<Employee> findBycompanyMail(String companyMail);
}
