package com.kaush.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kaush.pma.dto.EmployeeProject;
import com.kaush.pma.entities.Employee;

// first argument is going to be Entity type(what type we dealing with) and second argument is going to be type of primary key
//public interface EmployeeRepository extends CrudRepository<Employee, Long>{
@RepositoryRestResource(collectionResourceRel="apiemployees", path="apiemployees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

//	@Override
//	public List<Employee> findAll();
	
	@Query(nativeQuery = true, value="SELECT e.first_name as firstName, e.last_name as lastName," + 
			"COUNT (pe.employee_id) as projectCount FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " + 
			"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();

	// @Query(nativeQuery = true, value="SELECT * from employee where email=?") => me query liyanna one na spring data smart enough to know that it can query 
	// the database appropriately based on whatever you named
	public Employee findByEmail(String value);  // or i can write findEmployeeByEmail
	
	// another ex/
	public Employee findEmployeeByEmployeeId(long id); // EmployeeId make sure this is the actual property of the actual entity class
	
}
