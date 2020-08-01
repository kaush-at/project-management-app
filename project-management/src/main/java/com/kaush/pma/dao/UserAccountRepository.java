package com.kaush.pma.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kaush.pma.entities.UserAccount;

//public interface UserAccountRepository extends CrudRepository<UserAccount, Long> { // by just doing extends CrudRepository we get save save all such kind of ability
// to enable more features than CrudRepository we can use PagingAndSortingRepository
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
	
}
