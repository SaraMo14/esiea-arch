package com.esiea.fr.arch.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esiea.fr.arch.dto.UserDTO;
import com.esiea.fr.arch.service.UserService;

@Controller //annotation
public class UserController {
	@Value("${myvariable}")
	private String variable1;
	
	@Autowired
	private UserService userService;
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	
	@RequestMapping(value = "/api/v1/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){
		LOGGER.info("Firstname: "+ userDto.getFirstname());
		LOGGER.info("Lastname: "+ userDto.getLastname());		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
		LOGGER.info("Birthday: "+ ft.format(userDto.getBirthday()));
		LOGGER.info("Mobile: "+ userDto.getMobile());
		
		//System.out.println("Variable: "+ variable1);
	
		userService.createOrUpdateUser(userDto); 
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);
	}
}
