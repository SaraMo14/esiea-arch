package com.esiea.fr.arch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esiea.fr.arch.dto.UserDTO;
import com.esiea.fr.arch.entity.User;
import com.esiea.fr.arch.exception.AccountNotFoundException;
import com.esiea.fr.arch.exception.UserNotFoundException;
import com.esiea.fr.arch.repository.UserRepository;
import com.esiea.fr.arch.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class UserTest {

	  @Autowired
	  private UserService userService;


	  @Autowired
	  private UserRepository userRepository;
  
	  private UserDTO user;
	  @Before
		public void SetUp(){ 
	      System.out.println("Testing User controller ... ");
	      user = new UserDTO();
	      user.setFirstname("Mario");
	      user.setLastname("Rossi");
	      //userService.createUser(user);
	  }
	
		@After 
		public void TearDown(){
			user = null;
	  } 
		
		@Test
		public void testGetUserById() throws UserNotFoundException {
			long id = 13;
			assertEquals("Claire", userService.getUserById(id).getFirstname());
		}
		
		
		@Test
		public void testFindUserByLastname(){
			
			System.out.print(userRepository.findByLastname(user.getLastname()).getFirstname());
			assertEquals(user.getLastname(), userRepository.findByLastname(user.getLastname()).getLastname());
		}
	
		

}