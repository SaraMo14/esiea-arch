package com.esiea.fr.arch.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.esiea.fr.arch.dto.AccountDTO;
import com.esiea.fr.arch.dto.UserDTO;
import com.esiea.fr.arch.entity.Account;
import com.esiea.fr.arch.entity.User;
import com.esiea.fr.arch.exception.AccountNotFoundException;
import com.esiea.fr.arch.exception.UserNotFoundException;
import com.esiea.fr.arch.service.AccountService;
import com.esiea.fr.arch.service.UserService;

@Controller //annotation
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	private static final Logger LOGGER = LogManager.getLogger(AccountController.class);
	
	
	@RequestMapping(value = "/api/v1/createAccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDto) throws UserNotFoundException{
		accountService.createOrUpdateAccount(accountDto); 
		return new ResponseEntity<AccountDTO>(accountDto, HttpStatus.OK);
	}
	
	@GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> forAdmin(){
        return new ResponseEntity<String>("This URL is only accessible to the admin", HttpStatus.OK);
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('ROLE_STANDARD')")
    public ResponseEntity<String> forUser(){
    	return new ResponseEntity<String>("This URL is only accessible to the user", HttpStatus.OK);
    }
   
    //return accounts of a user
    @RequestMapping(path = "/api/v1/accounts/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getUserById(@PathVariable("id") Long id) {
        List<Account> list = accountService.getAccountsByUserId(id);
        return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/api/v1/deleteAccount/{username}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable("username") String username) throws AccountNotFoundException {
        accountService.deleteAccount(username);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
    @RequestMapping(value = "/api/v1/deactivate/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> deactivateAccount(@PathVariable String username) throws AccountNotFoundException{
    	int result = accountService.deactivateAccount(username); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/api/v1/activate/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> activateAccount(@PathVariable String username) throws AccountNotFoundException{
    	int result = accountService.activateAccount(username); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

    @RequestMapping(path = "/api/v1/account/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getAccountByUsername(@PathVariable("username") String username) throws AccountNotFoundException{
        Account account = accountService.getAccountByUsername(username);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/api/v1/account/changePassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changePassword(@RequestBody Account account) throws AccountNotFoundException{
    	accountService.changePassword(account.getPassword(), account.getUsername());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(path = "/api/v1/account/reset", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> resetPassword(@RequestBody String username) throws AccountNotFoundException{
        accountService.changePassword("password", username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
