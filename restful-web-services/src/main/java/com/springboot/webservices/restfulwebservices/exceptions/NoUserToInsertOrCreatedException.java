package com.springboot.webservices.restfulwebservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NoUserToInsertOrCreatedException extends RuntimeException{
	public NoUserToInsertOrCreatedException(String message) {
		super(message);
	}
}
