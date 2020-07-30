package com.kaush.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.pma.dao.UserAccountRepository;
import com.kaush.pma.entities.UserAccount;

@Service
public class UserAccountService {

	@Autowired
	UserAccountRepository usrRepo;
	
	public UserAccount saveUser(UserAccount user) {
		return usrRepo.save(user);
	}
	
}
