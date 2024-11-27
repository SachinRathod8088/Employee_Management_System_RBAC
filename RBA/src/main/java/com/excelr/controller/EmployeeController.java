package com.excelr.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.excelr.model.Employee;
import com.excelr.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

	/*
	 * @GetMapping("/edit/{empId}") public String updateEmployeeForm(@PathVariable
	 * String empId, Model model) { Optional<Employee> employeeOpt =
	 * employeeService.getEmployeeByEmpId(empId); if (employeeOpt.isPresent()) {
	 * model.addAttribute("employee", employeeOpt.get()); return "edit"; // Make
	 * sure the template name matches exactly (edit.html) } else { return
	 * "redirect:/admin/dashboard"; // Handle the case when the employee is not
	 * found } }
	 */
    @GetMapping("/view/{empId}")
    public String viewEmployeeDetails(@PathVariable("empId") String empId, Model model) {
        Optional<Employee> employeeOpt = employeeService.getEmployeeByEmpId(empId);

        if (employeeOpt.isPresent()) {
            model.addAttribute("employee", employeeOpt.get());
            return "/employee/user"; // return the view template to display employee details
        } else {
            model.addAttribute("error", "Employee not found");
            return "Not Found"; // Redirect if the employee is not found
        }
    }
}
