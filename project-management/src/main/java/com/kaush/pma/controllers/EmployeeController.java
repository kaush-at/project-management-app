package com.kaush.pma.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaush.pma.dao.EmployeeRepository;
import com.kaush.pma.entities.Employee;
import com.kaush.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		Iterable<Employee> employees = empRepo.findAll();
		model.addAttribute("employeeList", employees);
		return "employees/list-employees";
	} 
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new-employee";
	}

	@PostMapping("/save")
	public String addEmployee(Model model, @Valid Employee employeee,  Errors errors) { 
		System.out.println("EEERRRRRRROOOOOOOORRRRRR>>>> "+ errors.hasErrors());
		if(errors.hasErrors()) {
			return "employees/new-employee";
		}
		// save to the database using an employee CRUD repository
		empRepo.save(employeee);
		return "redirect:/employees/";
	}
	
	@GetMapping("/update")
	public String displayEmployeeForm(@RequestParam("id") long theId, Model model) {
		Employee emp = empRepo.findById(theId).get();
		model.addAttribute("employee" , emp);
		return "employees/new-employee";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long theId, Model model) {
		Employee emp = empRepo.findById(theId).get();
		empService.delete(emp);
		return "redirect:/employees";
	}
	
	
}
