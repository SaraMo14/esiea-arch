package com.esiea.fr.arch.exception;

import java.text.MessageFormat;

public class UserNotFoundException extends Exception{

	public UserNotFoundException(long id) {
		super(MessageFormat.format("Couldn't find user with id: {0}", id));
	}
}
