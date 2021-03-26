package com.hig.oracleformsmigration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException(String message, Throwable t) {
		super(message, t);
	}
}
