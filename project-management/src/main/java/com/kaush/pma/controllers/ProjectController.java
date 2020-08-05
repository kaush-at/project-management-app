package com.kaush.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaush.pma.dao.EmployeeRepository;
import com.kaush.pma.dao.ProjectRepository;
import com.kaush.pma.dto.TimeLineChartData;
import com.kaush.pma.entities.Employee;
import com.kaush.pma.entities.Project;
import com.kaush.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectService projService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectList", projects);
		return "projects/list-projects";
	} 
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project(); 
		model.addAttribute("project", aProject);
		Iterable<Employee> employees = empRepo.findAll();
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
		
	}
	
	@PostMapping("/save")
	public String saveProject(Project project, Model model,@RequestParam List<Long> employees) { 	
		System.out.println("#################################################### ");
		proRepo.save(project); 
		return "redirect:/projects";	
	}
	
	@GetMapping("/update")
	public String updateProject(@RequestParam("pId") long id,Project project, Model model) {
		Project pro = proRepo.findById(id).get();
		model.addAttribute("project",pro);
		
		Iterable<Employee> employees = empRepo.findAll();
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	@GetMapping("/delete")
	public String deleteProject(@RequestParam("id") long id, Model model) {
		Project proj = proRepo.findById(id).get();
		projService.delete(proj);
		return "redirect:/projects";
	}
	
	@GetMapping("/timelines")
	public String displayProjectTimeLines(Model model) throws JsonProcessingException {
		List<TimeLineChartData> timeLineData =  projService.getTimeLineChartDatas();
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsonTimeLineString = objMapper.writeValueAsString(timeLineData);
		
		model.addAttribute("projectTimeList", jsonTimeLineString);
		
		return "projects/project-timelines";
	}
	
}
