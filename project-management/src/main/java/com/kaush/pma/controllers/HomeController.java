package com.kaush.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaush.pma.dao.EmployeeRepository;
import com.kaush.pma.dao.ProjectRepository;
import com.kaush.pma.dto.ChartData;
import com.kaush.pma.dto.EmployeeProject;
import com.kaush.pma.entities.Project;
import com.kaush.pma.springExample.Car;

@Controller
public class HomeController {

	// this is use for demo purpose of Bean creation and put those in to Spring contex
	@Autowired
	Car car;
	
	// this is how we access the properties inside the property files
	@Value(value = "${version}")
	private String version;

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<>();
		
		model.addAttribute("version", version);
		// quering database for projects
		List<Project> projects = proRepo.findAll();  // findAll method we get from extended CrudRepository interface it returns iterable 
													// object therefore we customize it in our ProjectRep[o interface
		model.addAttribute("projectList", projects);
		
		List<ChartData> chartData = proRepo.getProjectStatus();
		
		// Lets convert projectData object into a JSON structure for use in javascript(using object mapper)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(chartData);
		// this json String should look like this => [["NOTSTARTED", 1],["INPROGRESS", 2],["COMPLETED", 1]] 
		
		model.addAttribute("projectStatusCount", jsonString);
		
		// quering database for employee
//		List<Employee> employees = empRepo.findAll(); we change this because we use project_emploee table
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeeListProjectCount", employeesProjectCount);
		
		return "main/home";
	}

}
