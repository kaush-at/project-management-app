
package com.kaush.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kaush.pma.dao.EmployeeRepository;
import com.kaush.pma.dao.ProjectRepository;
import com.kaush.pma.springExample.Car;
import com.kaush.pma.springExample.Doors;
import com.kaush.pma.springExample.Engine;
import com.kaush.pma.springExample.Tires;


@SpringBootApplication(scanBasePackages= {"com.kaush.pma","com.kaush.utills"}) 
																		
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository projRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	
}
