package com.excelr.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.excelr.model.Employee;
//import com.excelr.model.FinanceDetails;
import com.excelr.service.EmployeeService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "/admin/dashboard";
    }
    @GetMapping("/view/{empId}")
    public String viewEmployeeDetails(@PathVariable("empId") String empId, Model model) {
        Optional<Employee> employeeOpt = employeeService.getEmployeeByEmpId(empId);

        if (employeeOpt.isPresent()) {
            model.addAttribute("employee", employeeOpt.get());
            return "view"; // return the view template to display employee details
        } else {
            model.addAttribute("error", "Employee not found");
            return "redirect:/admin/dashboard"; // Redirect if the employee is not found
        }
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, HttpSession session) {
        employeeService.addEmployee(employee);
        session.setAttribute("msg", "successfully Added");
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/edit/{empId}")
    public String updateEmployeeForm(@PathVariable String empId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeByEmpId(empId).orElse(null));
        return "edit";
    }


    @PostMapping("/edit/{empId}")
    public String updateEmployee(@PathVariable String empId,@ModelAttribute  Employee employee, Model model) throws Exception{
        employeeService.updateEmployee(empId,employee);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, HttpSession session) {
        employeeService.deleteEmployee(id);
        session.setAttribute("msg", "successfully deleted");
        return "redirect:/admin/dashboard";
    }
}

