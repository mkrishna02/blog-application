package com.learn.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learn.blog.payloads.ApiResponse;


/**
 * @author Krishnanand Mishra
 * 
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// 	You can use any required exception class name here. ResourceNotFoundException is used in current scenario.
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){ // from object ex, you can get the error message, stack trace and their values. 
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	/*@ExceptionHandler(ConstraintViolationException.class)
	public  ResponseEntity<Map<String , String>> handleConstraintViolationException(ConstraintViolationException ex){
		Map<String, String> resp = new HashMap<>();
		String fieldName= ex.getConstraintName();
		String message = ex.getMessage();
		resp.put(fieldName, message);
		return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
	}*/
	
	
	
}
