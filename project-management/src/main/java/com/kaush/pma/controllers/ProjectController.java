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
	
	
	@Autowired // we gives responsibility to spring container to inject an instance(auto created instance)
	ProjectRepository proRepo;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectList", projects);
		return "projects/list-projects";
	} 
	
	@RequestMapping("/new") //OR @GetMapping("/new") 
	public String displayProjectForm(Model model) { // model is use to exchange the data between view and controller
		
		Project aProject = new Project(); // thats why we created default constructor in the project class thats why we can create
										  // this empty project
		
		model.addAttribute("project", aProject); // name of the model object should same as th:object="${project}" in the HTML page
		
		return "projects/new-project"; // no need .html -> because Thymeleaf is smart enough to match it with name 
		
	}
	
	// get the form data
	@PostMapping("/save") // OR @RequestMapping("/save", method=RequestedMethod.POST)
	public String saveProject(Project project, Model model) {
		
		proRepo.save(project);
		
		// use redirect to prevent duplicate submissions (when user submit two three times it can submit duplicates) 
		// therefore always try to do redirect after saving data  
		return "redirect:/projects/new";
		
	}
}
