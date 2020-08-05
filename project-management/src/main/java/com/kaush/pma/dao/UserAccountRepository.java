package com.kaush.pma.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kaush.pma.entities.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
	
}
