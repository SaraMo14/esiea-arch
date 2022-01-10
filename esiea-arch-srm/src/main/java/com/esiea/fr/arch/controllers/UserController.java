package com.esiea.fr.arch.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.esiea.fr.arch.dto.UserDTO;
import com.esiea.fr.arch.entity.User;
import com.esiea.fr.arch.exception.UserNotFoundException;
import com.esiea.fr.arch.service.UserService;

@Controller //annotation
public class UserController {
	
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
		userService.createUser(userDto); 
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);
	}
	
	@GetMapping("/api/v1/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/api/v1/updateUser/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDto) throws UserNotFoundException{
		int result = userService.updateUser(id, userDto); 
		if (result == 0) {
			throw new UserNotFoundException(id);
		}
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);
	}


    @RequestMapping(path = "/api/v1/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws UserNotFoundException{
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(path = "/api/v1/deleteUser/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") Long id) throws UserNotFoundException {
        userService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
}
