package com.esiea.fr.arch.controllers;


import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esiea.fr.arch.dto.UserDTO;

@Controller //annotation
public class UserController {
	@Value("${myvariable}")
	private String variable1;
	
	
	@RequestMapping(value = "/api/v1/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
		System.out.println("Firstname: "+ user.getFirstname());
		System.out.println("Lastname: "+ user.getLastname());		
		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
		System.out.println("Birthday: "+ ft.format(user.getBirthday()));
		System.out.println("Mobile: "+ user.getMobile());
		
		System.out.println("Variable: "+ variable1);
		
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
}
