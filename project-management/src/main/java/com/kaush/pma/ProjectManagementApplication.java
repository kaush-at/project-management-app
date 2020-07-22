package com.kaush.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kaush.pma.dao.EmployeeRepository;
import com.kaush.pma.dao.ProjectRepository;

@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository projRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

	/*
	 * 
		Command Line Runner is an interface. It is used to execute the code after the Spring Boot application started. 
		The example given below shows how to implement the Command Line Runner interface on the main class file.
		
		1). method 1
			extends CommandLineRunner and overide the run method
		
		@SpringBootApplication
		public class ProjectManagementApplication implements CommandLineRunner {
		
		public static void main(String[] args) {
      		SpringApplication.run(ProjectManagementApplication.class, args);
   		}
	 *  @Override
		public void run(String... arg0) throws Exception {
		    System.out.println("Hello world from Command Line Runner");
		}
	 * 
	 * 2). method 2 
	 * 		create a separate bean without extends CommandLineRunner as bellow
	 * 
	 */
	
//	@Bean
//	CommandLineRunner runner() {
//		
//		return args -> {
//			
//			Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
//			Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com");
//			Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com");
//
//			Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
//			Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com");
//			Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com");
//
//			Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com");
//			Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com");
//			Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com");
//
//			
//			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
//					+ "the final deployment of the software into production");
//			Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
//					+ "for the year and figureout who will be promoted");
//			Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
//					+ "been damaged due to hurricane in the region. This needs to be reconstructed");
//			Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
//					+ "security needs to be improved and proper security team needs to be hired for "
//					+ "implementation");
//			
//			
//			
//			// need to set both sides of the relationship manually
//
//			pro1.addEmployee(emp1);
//			pro1.addEmployee(emp2);
//			pro2.addEmployee(emp3);
//			pro3.addEmployee(emp1);
//			pro4.addEmployee(emp1);
//			pro4.addEmployee(emp3);
//			
////			pro1.getEmployees().add(emp1);
////			pro1.getEmployees().add(emp2);
////			pro2.getEmployees().add(emp3);
////			pro3.getEmployees().add(emp1);
////			pro4.getEmployees().add(emp1);
////			pro4.getEmployees().add(emp3);
//			
//			// need to set both sides of the relationship manually
//			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
//			emp2.setProjects(Arrays.asList(pro1));
//			emp3.setProjects(Arrays.asList(pro2, pro4));
//			
//			// save employees in database
//			empRepo.save(emp1);
//			empRepo.save(emp2); 
//			empRepo.save(emp3); 
//			empRepo.save(emp4);
//			empRepo.save(emp5); 
//			empRepo.save(emp6); 
//			empRepo.save(emp7); 
//			empRepo.save(emp8); 
//			empRepo.save(emp9);
//
//			
//			// save projects in database
//
//			projRepo.save(pro1);
//			projRepo.save(pro2); 
//			projRepo.save(pro3); 
//			projRepo.save(pro4);
//			
//			
//		};
//	}
	
	/*
	 * we can do this using sql file (we create that sql file inside our resource folder ex/ data.sql)
	 */
}
