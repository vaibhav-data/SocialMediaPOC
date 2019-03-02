package com.vaibhav.server.main.user;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException {
	/**
	 * if user id is not found in the list throw exception
	 * @param arg0
 	 */

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
	