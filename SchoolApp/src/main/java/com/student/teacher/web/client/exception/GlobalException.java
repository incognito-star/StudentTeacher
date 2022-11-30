package com.student.teacher.web.client.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, 
			WebRequest request){
		String message = "Student/Teacher Member not found";//"Some meaningful error message";
		return new ResponseEntity(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> duplicateEntityException(Exception ex, WebRequest req){
		String message = "Unique index or primary key violation"; //"Some meaningful error message";
		return new ResponseEntity(message,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest req){
		String message = "Fatal Error Occured";//"Some meaningful error message";
		return new ResponseEntity(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
