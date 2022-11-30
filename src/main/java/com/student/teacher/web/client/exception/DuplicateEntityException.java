package com.student.teacher.web.client.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class DuplicateEntityException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateEntityException(String message) {
		super(message);
	}
}
