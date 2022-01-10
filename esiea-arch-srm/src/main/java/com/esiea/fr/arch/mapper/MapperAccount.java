package com.esiea.fr.arch.mapper;

import org.springframework.stereotype.Component;

import com.esiea.fr.arch.dto.AccountDTO;
import com.esiea.fr.arch.entity.Account;
import com.esiea.fr.arch.entity.User;
import com.esiea.fr.arch.exception.UserNotFoundException;

@Component
public class MapperAccount {
	
    public Account accountDTOToAccount(AccountDTO accountDTO1) throws UserNotFoundException {
        if ( accountDTO1 == null ) {
            return null;
        }
        User user = new User();
        user.setId(accountDTO1.getUserID());
        Account account = new Account();
        account.setUsername( accountDTO1.getUsername());
        account.setPassword( accountDTO1.getPassword());
        account.setCreationDate(accountDTO1.getCreationDate());
        account.setUser(user);
        account.setEndDate(accountDTO1.getEndDate() );
        account.setActivated(accountDTO1.isActivated());
        account.setType(accountDTO1.getType() );
        
        return account;
    }
}
