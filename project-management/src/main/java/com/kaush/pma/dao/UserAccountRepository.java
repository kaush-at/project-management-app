package com.kaush.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.kaush.pma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> { // by just doing extends CrudRepository we get save save all such kind of ability

	
}
