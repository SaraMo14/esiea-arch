package com.esiea.fr.arch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esiea.fr.arch.entity.User;
import com.esiea.fr.arch.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void createOrUpdateUser(User user) {
		userRepository.save(user);
	}
}
