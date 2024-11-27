package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.model.Employee;
import com.excelr.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    public Optional<Employee> getEmployeeByMail(String companyMail) {
        return employeeRepository.findBycompanyMail(companyMail);
    }
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
//
//    public Employee updateEmployee(Employee employee) {
//        return employeeRepository.save(employee);
//    }
//    @PostMapping("/edit/{empId}")
    public Employee updateEmployee(String empId ,Employee employee) throws Exception {
        // Fetch the existing employee record using the instance of employeeService
        Employee existingEmployee = employeeRepository.findByEmpId(empId)
        		.orElseThrow(() -> new Exception("Employee not found"));
        
//            Employee existingEmployee = existingEmployeeOpt.get();
//            // Update fields that can be modified
            existingEmployee.setFullName(employee.getFullName());
            existingEmployee.setPersonalEmail(employee.getPersonalEmail());
            existingEmployee.setMobile(employee.getMobile());
            existingEmployee.setOfficePhone(employee.getOfficePhone());
            existingEmployee.setHrName(employee.getHrName());
            existingEmployee.setEndDate(employee.getEndDate());
            existingEmployee.setClientProjectName(employee.getClientProjectName());
            existingEmployee.setReportingManager(employee.getReportingManager());
            existingEmployee.setProjectCode(employee.getProjectCode());
            existingEmployee.setStartDate(employee.getStartDate());
            existingEmployee.setCity(employee.getCity());
            existingEmployee.setAddressLine1(employee.getAddressLine1());
            existingEmployee.setAddressLine2(employee.getAddressLine2());
            existingEmployee.setPinCode(employee.getPinCode());
            existingEmployee.setDateOfJoining(employee.getDateOfJoining());
            existingEmployee.setCity1(employee.getCity1());
//            // Save the updated employee
            
            return employeeRepository.save(existingEmployee);

//        return "redirect:/admin/dashboard";
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> getEmployeeByEmpId(String empId) {
        return employeeRepository.findByEmpId(empId);
    }
}
