package com.esiea.fr.arch.exception;

import java.text.MessageFormat;

public class AccountNotFoundException extends Exception{

	public AccountNotFoundException(String username) {
		super(MessageFormat.format("Couldn't find account with username: {0}", username));
	}
}
