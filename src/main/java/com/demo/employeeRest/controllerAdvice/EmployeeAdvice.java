package com.demo.employeeRest.controllerAdvice;

import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeAdvice {
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<String> employeeNotFound(NoSuchElementException exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<String> duplicateRecord(ConstraintViolationException exception){
		return new ResponseEntity<String>(exception.getCause().getMessage(), HttpStatus.CONFLICT);
	}
	
}
