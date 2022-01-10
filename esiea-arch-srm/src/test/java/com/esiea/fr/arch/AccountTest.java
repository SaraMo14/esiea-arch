package com.esiea.fr.arch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.esiea.fr.arch.entity.Account;
import com.esiea.fr.arch.entity.User;
import com.esiea.fr.arch.exception.AccountNotFoundException;
import com.esiea.fr.arch.repository.AccountRepository;
import com.esiea.fr.arch.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class AccountTest {

  @Autowired
  private MockMvc mvc;


  @Autowired
  private AccountService accountService;
  
  private Account account;
  
  @Before
	public void SetUp(){ 
      System.out.println("Testing account controller ... ");
      account = new Account();
      account.setUsername("inexisting_username");
      account.setPassword("password");
  }

	@After 
	public void TearDown(){
		account = null;
  } 
	
//Login test for non existing credentials
  @Test
  public void testWrongLogin() throws Exception {
	  
	  Object randomObj = new Object() {
		  public final String username = account.getUsername();
		  public final String password = account.getPassword();
      };

      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(randomObj);

      
	  RequestBuilder request = MockMvcRequestBuilders.post("/authenticate")
	            .content(json)
	            .contentType(MediaType.APPLICATION_JSON);
	    mvc.perform(request)
	            .andDo(print())
	            .andExpect(status().isUnauthorized());	    
  }

  //Throws exception if there is no account associated to that username
  @Test(expected=AccountNotFoundException.class) 
  public void testGetAccountByUsername() throws AccountNotFoundException {
		 accountService.getAccountByUsername(account.getUsername());
  }
}