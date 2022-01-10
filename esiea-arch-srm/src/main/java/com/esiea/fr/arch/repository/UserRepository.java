package com.esiea.fr.arch.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.esiea.fr.arch.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public User findByBirthday(Date birthday);
	public User findByFirstname(String firstname);
	public User findByLastname(String lastname);
	
	@Transactional
	@Modifying
	@Query(value="update User u set u.firstname = ?1, u.lastname = ?2, u.mobile = ?3, u.birthday = ?4 where u.id = ?5")
	public int setUserInfoById(String firstname, String lastname, String mobile, Date birthday, long userId);
}
