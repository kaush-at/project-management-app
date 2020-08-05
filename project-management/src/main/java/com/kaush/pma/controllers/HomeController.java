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

	@Autowired
	Car car;
	
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
		List<Project> projects = proRepo.findAll();  
													
		model.addAttribute("projectList", projects);
		
		List<ChartData> chartData = proRepo.getProjectStatus();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(chartData);
		
		model.addAttribute("projectStatusCount", jsonString);
		
		model.addAttribute("employeeListProjectCount", employeesProjectCount);
		
		return "main/home";
	}

}
