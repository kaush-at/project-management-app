package com.kaush.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kaush.pma.entities.Employee;

// first argument is going to be Entity type(what type we dealing with) and second argument is going to be type of primary key
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	@Override
	public List<Employee> findAll();
}
