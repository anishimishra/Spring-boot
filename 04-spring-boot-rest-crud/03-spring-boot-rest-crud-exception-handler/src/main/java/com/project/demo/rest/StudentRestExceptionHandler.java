package com.project.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	// add exception handling code
	// add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {

		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return a ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handler to catch any exception(catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage()); // set message here if we want a user friendly message
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
