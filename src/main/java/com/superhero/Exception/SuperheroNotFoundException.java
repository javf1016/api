package com.superhero.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SuperheroNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SuperheroNotFoundException(Long id) {
		super("Could not find superhero with id: " + id);
	}
	
}