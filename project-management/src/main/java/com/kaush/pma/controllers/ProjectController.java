package com.kaush.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaush.pma.dao.ProjectRepository;
import com.kaush.pma.entities.Employee;
import com.kaush.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	
	@Autowired 
	ProjectRepository proRepo;
	
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
		return "projects/new-project";  	
	}
	
	// get the form data
	@PostMapping("/save") 
	public String saveProject(Project project, Model model) {
		proRepo.save(project);
		return "redirect:/projects/new";
		
	}
}
