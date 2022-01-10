package com.esiea.fr.arch.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esiea.fr.arch.dto.AccountDTO;
import com.esiea.fr.arch.entity.Account;
import com.esiea.fr.arch.entity.User;
import com.esiea.fr.arch.exception.AccountNotFoundException;
import com.esiea.fr.arch.exception.UserNotFoundException;
import com.esiea.fr.arch.mapper.MapperAccount;
import com.esiea.fr.arch.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	 
	@Autowired
    private MapperAccount mapperAccount;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void createOrUpdateAccount(AccountDTO accountDto) throws UserNotFoundException {
		Account account = mapperAccount.accountDTOToAccount(accountDto);
		String clear = account.getPassword();
		account.setPassword(getEncodedPassword(clear));
		accountRepository.save(account);
	}
	
	public Account fetchUserByUsernameAndPassword(String username, String password) {
		return accountRepository.findByUsernameAndPassword(username, password);
	}
	
	
	public List<Account> getAccountsByUserId(Long userId) {
		return accountRepository.findAccountsByUserId(userId);
	}
	
	//return a specific account given the username
	public Account getAccountByUsername(String username) throws AccountNotFoundException {
		
		Account a = accountRepository.findByUsername(username); 
		if (a == null) {
			throw new AccountNotFoundException(username);
		}else {
			return a;
		}
		
	}
	
	public void changePassword(String password, String username) {
		accountRepository.changePassword(getEncodedPassword(password), username);
	}
	
	//delete a specific account given the username
	public Account deleteAccount(String username) throws AccountNotFoundException {
		//check if it exists
		Account account = getAccountByUsername(username);
		accountRepository.delete(account);
		return account;
	}
	
	//deactivate a specific account given the username
	public int deactivateAccount(String username) throws AccountNotFoundException {
		/*//check if it exists
		Account accountToEdit = getAccountByUsername(username);
		//check if active
		if(accountToEdit.isActivated() == true)
			accountToEdit.setActivated(false);*/
		int result = accountRepository.deactivate(username);
		if (result==0) {
			throw new AccountNotFoundException(username);
		}else {
			return result;
		}
		
		
	}
	
	public int activateAccount(String username) throws AccountNotFoundException {
		int result = accountRepository.activate(username);
		if (result==0) {
			throw new AccountNotFoundException(username);
		}else {
			return result;
		}
	}
	
	public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
	
	
}
