package com.kaush.pma.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.kaush.pma.dao.EmployeeRepository;
import com.kaush.pma.entities.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String>{

	@Autowired
	EmployeeRepository empRepo;  // meyawa autowire kare meya gen tama check karane email eka nisa
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		System.out.println("Entered Constraint violation method");
		Employee emp = empRepo.findByEmail(value);
		
		if(emp != null) 
			return false;
		else	
			return true;
	}

}