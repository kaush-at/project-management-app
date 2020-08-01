package com.kaush.pma;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kaush.pma.dao.ProjectRepository;
import com.kaush.pma.entities.Project;

@SpringBootTest  // habai methanata projectRepositoryIntegrationTest eke tiyena annotation tika sql files ehema daala liyana eka hodai mokada api sql 
//file tika production ekata denna one ewa test karaganna one nisa 
class ProjectManagementApplicationTests {
	
	@Autowired
	ProjectRepository proRepo;
	@Test
	void contextLoads() {
//			Project newProject = new Project("New Test Project","COMPLETE","Test description");
//			proRepo.save(newProject);
//			 
//			assertEquals(9, proRepo.findAll().size()); //Assert that expected and actual are equal. and make sure to import import static org.junit.Assert.assertEquals;
		}
	

}
