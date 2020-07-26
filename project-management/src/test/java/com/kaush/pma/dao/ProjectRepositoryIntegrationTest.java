package com.kaush.pma.dao;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.kaush.pma.ProjectManagementApplication;
import com.kaush.pma.dao.ProjectRepository;
import com.kaush.pma.entities.Project;
/*
@ContextConfiguration(classes=ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest  // this is use for if you have temporary database that you wanna write test casses with it
@SqlGroup({@Sql(executionPhase= ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
	@Sql(executionPhase= ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")}) // here we specify some of the sql file that we need to run
public class ProjectRepositoryIntegrationTest {

	@Autowired
	ProjectRepository proRepo;
	
	@Test // to run a test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("New Test Project","COMPLETE","Test description");
		proRepo.save(newProject);
		 
		assertEquals(5, proRepo.findAll().size()); //Assert that expected and actual are equal. and make sure to import import static org.junit.Assert.assertEquals;
	}
}

*/