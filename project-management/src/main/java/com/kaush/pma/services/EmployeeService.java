package com.kaush.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.pma.dao.EmployeeRepository;

@Service
public class EmployeeService{

	/* 
	 * ---------------
	 * 1	field injection
	 *  -------------
	@Autowired
	EmployeeRepository empRepo;
	
	*/
	
	/*
	 * ---------------------
	 * 2    Constructor injection
	 * ---------------------
	 
	EmployeeRepository empRepo;
	
	public EmployeeService(EmployeeRepository empRepo) {
		super()
		this.empRepo = empRepo;
	}
	
	*/
	
	
	/*
	 * ---------------------
	 * 3    Setter injection
	 * ---------------------
	 */
	@Autowired
	EmployeeRepository empRepo;
	public void setEmployeeService(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
}
