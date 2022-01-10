package com.esiea.fr.arch.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.esiea.fr.arch.dto.AccountDTO;
import com.esiea.fr.arch.entity.Account;
import com.esiea.fr.arch.entity.User;

public interface AccountRepository extends CrudRepository<Account, String>{
	public Account findByUsernameAndPassword(String username, String password);
	public Account findByUsername(String username);
	
	
	@Transactional
	@Modifying
	@Query(value="update Account a set a.activated= 0 where a.username = ?1")
	public int deactivate(String username);
	
	@Transactional
	@Modifying
	@Query(value="update Account a set a.activated= 1 where a.username = ?1")
	public int activate(String username);

	@Transactional
	@Modifying
	@Query(value="update Account a set a.password= ?1 where a.username = ?2")
	public int changePassword(String password, String username);
	
	public List<Account> findAccountsByUserId( Long userId);
}
