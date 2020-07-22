package com.kaush.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//This class structure is going to map to a table structure in database
// try to create mapping with a java world with a database world thanks tp java persistence library
// most specifically JPA(Java persistence API) that is part of the hibernate module withing spring

@Entity
public class Project {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO) // this is how we out-source to Hibernate to create ID
	@GeneratedValue(strategy=GenerationType.IDENTITY) // if we use external file to insert data initially
	private long projectId;
	private String name;
	private String stage; //NOTSTARTE,COMPLETE,INPROGRESS
	private String description;
	
	public Project() {
		
	}
	
	// we miss the id here because we need to let database(outsource to the database to do that )to create a unique id
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	/*
	 * 	@OneToMany(mappedBy="project")
	 *  private List<Employee> employees;
	 * 
	 */
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id") ,
										  inverseJoinColumns = @JoinColumn(name = "employee_id") )
	private List<Employee> employees;
	
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	// convenience method
	public void addEmployee(Employee emp) {
		if(employees == null) {
			employees= new ArrayList<>();
		}
		employees.add(emp);
	}
	
}
