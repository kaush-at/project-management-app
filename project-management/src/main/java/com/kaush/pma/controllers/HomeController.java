package com.kaush.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kaush.pma.dao.EmployeeRepository;
import com.kaush.pma.dao.ProjectRepository;
import com.kaush.pma.entities.Employee;
import com.kaush.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		// quering database for projects
		List<Project> projects = proRepo.findAll();  
													
		model.addAttribute("projectList", projects);
		
		// quering database for employee
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeeList", employees);
		
		return "main/home";
	}

}
