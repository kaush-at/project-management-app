package com.kaush.pma.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaush.pma.dao.EmployeeRepository;
import com.kaush.pma.entities.Employee;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public Iterable<Employee> getEmployees(){
		//List<Employee> empList = empRepo.findAll();
		
		return empRepo.findAll();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return empRepo.findById(id).get();
	}
	
	// meke wishesha endpoint ekak define karala nathi nisa  => main eka mai (/app-api/employees) ganne
//	@PostMapping(consumes = "application/json")  // we define by consume this method accept these type of data formats
//	@ResponseStatus(HttpStatus.CREATED) // to give seperate response code other than 200
//	public Employee create(@RequestBody Employee emp) {  // body of the request should Employee in JSON format(consume param eken kiyanne eka)
//		return empRepo.save(emp);
//	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@RequestBody @Valid Employee emp) {
		return empRepo.save(emp);
	}
	
	@PutMapping(consumes = "application/json") // when we do update using this we do full update because of our cascade delete rule it delete 
	@ResponseStatus(HttpStatus.OK)							   // other records that relate to that updated recore therefore it is better to update partially
	public Employee update(@RequestBody @Valid Employee employee) {	// that is where @patch partial update comming to the picture
		return empRepo.save(employee);
	}
	
	@PatchMapping(path="/{id}", consumes="application/json")
	public Employee partialUpdate(@PathVariable("id") Long id, @RequestBody Employee emp) {
		Employee employee = empRepo.findById(id).get();
		if(emp.getEmail() != null) {
			employee.setEmail(emp.getEmail());
		}
		if(emp.getFirstName() != null) {
			employee.setFirstName(emp.getFirstName());
		}
		if(emp.getLastName() != null) {
			employee.setLastName(emp.getLastName());
		}
		
		return empRepo.save(employee);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
		empRepo.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			
		}
	}
	
	
}
