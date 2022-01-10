package com.esiea.fr.arch.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esiea.fr.arch.dto.UserDTO;
import com.esiea.fr.arch.entity.Account;
import com.esiea.fr.arch.entity.User;
import com.esiea.fr.arch.exception.AccountNotFoundException;
import com.esiea.fr.arch.exception.UserNotFoundException;
import com.esiea.fr.arch.mapper.MapperUser;
import com.esiea.fr.arch.repository.AccountRepository;
import com.esiea.fr.arch.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//later added
	@Autowired
	private AccountRepository accountRepository;
	
	 
	@Autowired
    private MapperUser mapperUser;
	
	public void createUser(UserDTO userDto) {
		User user = mapperUser.userDTOToUser(userDto);
		userRepository.save(user);
	}
	
	public int updateUser(Long id, UserDTO userDto) {
		return userRepository.setUserInfoById(userDto.getFirstname(), userDto.getLastname(), userDto.getMobile(), userDto.getBirthday(), id);
	}
	
	//addedlater
	//return a specific user given the id
	public User getUserById(Long id) throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}

	//delete user given the id
	public void deleteUser(Long id) throws UserNotFoundException {
		User user= getUserById(id);
		userRepository.delete(user);
	}

	 public List<User> findAllUsers() {
	    return (List<User>) userRepository.findAll();
	 }
}
