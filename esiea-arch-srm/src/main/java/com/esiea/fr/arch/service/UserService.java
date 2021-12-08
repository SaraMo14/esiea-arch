package com.esiea.fr.arch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esiea.fr.arch.dto.UserDTO;
import com.esiea.fr.arch.entity.User;
import com.esiea.fr.arch.mapper.MapperUser;
import com.esiea.fr.arch.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	 
	@Autowired
    private MapperUser mapperUser;
	
	public void createOrUpdateUser(UserDTO userDto) {
		User user = mapperUser.userDTOToUser(userDto);
		userRepository.save(user);
	}
}
