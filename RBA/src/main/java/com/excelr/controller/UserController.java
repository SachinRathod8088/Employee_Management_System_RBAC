package com.excelr.controller;

import java.security.Principal;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.excelr.DTO.UserDto;
import com.excelr.model.Employee;
import com.excelr.model.User;
import com.excelr.service.CustomUserDetail;
import com.excelr.service.EmployeeService;
//import com.excelr.model.Employee;
//import com.excelr.service.EmployeeService;
import com.excelr.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserDetailsService userDetailsService;
	
	 @Autowired
	    private EmployeeService employeeService;


	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}

	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "login";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/user")
	public String userPage(Model model, Principal principal) {
	    // Fetch the logged-in user's email (username) from the Principal object
	    String loggedInEmail = principal.getName();

	    // Fetch the user based on the logged-in email/username
	    UserDetails userDetails = userDetailsService.loadUserByUsername(loggedInEmail);

	    // You need an instance of 'User' to call getUsername() method
	    // Assuming 'userDetails' is an instance of 'User' or you need to cast it
	    if (userDetails instanceof CustomUserDetail) {
	        User user = ((CustomUserDetail) userDetails).getUser();  // Assuming 'CustomUserDetail' wraps 'User'

	        // Now call instance methods on the 'user' object
	        String userEmail = user.getEmail();  // Correct way to call getEmail()
	        
	        // Fetch the employee based on the user's email stored in the User table
	        Optional<Employee> employeeOpt = employeeService.getEmployeeByMail(userEmail);  // Assuming employee's email matches user's email

	        if (employeeOpt.isPresent()) {
	            Employee employee = employeeOpt.get(); // Extract the Employee from Optional
	            
	            // Pass employee details to the model to display on the page
	            model.addAttribute("employee", employee);
	            
	            // Redirect to the employee dashboard (or another page where the employee details are displayed)
	            return "employee/user";  // This page will display employee details
	        }
	    }

	    // Handle case where the employee is not found
	    model.addAttribute("error", "Employee details not found for the logged-in user");
	    return "error/403";  // Return to an error page if the employee is not found
	}




}
