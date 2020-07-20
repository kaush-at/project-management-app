package com.kaush.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//This class structure is going to map to a table structure in database
// try to create mapping with a java world with a database world thanks tp java persistence library
// most specifically JPA(Java persistence API) that is part of the hibernate module withing spring

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // this is how we out-source to DB to create ID
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

	@OneToMany
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
	
	
	
}
