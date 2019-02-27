package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	//Exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse>handleException(StudentNotFoundException e){
		StudentErrorResponse error=new StudentErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

	//Exception handler for all
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse>handleException(Exception e){
		StudentErrorResponse error=new StudentErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}	
}
