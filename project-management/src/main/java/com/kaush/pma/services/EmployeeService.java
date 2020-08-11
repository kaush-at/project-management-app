package com.kaush.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.pma.dao.EmployeeRepository;
import com.kaush.pma.dto.EmployeeProject;
import com.kaush.pma.entities.Employee;

@Service
public class EmployeeService{

	@Autowired
	EmployeeRepository empRepo;
	
	public void setEmployeeService(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public Iterable<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProject(){
		return empRepo.employeeProjects();
	}

	public void delete(Employee emp) {
		empRepo.delete(emp);
	}
}
