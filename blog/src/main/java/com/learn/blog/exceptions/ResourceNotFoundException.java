package com.learn.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * serialVersionUID added because of warning. 
	 * And can be removed if creates any issue. 
	 */
	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		//super(String.format("%s not found with %s : %l", resourceName, fieldName, fieldValue));
		//We are getting format specifier here because we have a format specifier %l for fieldValue in ResourceNotFoundException class 
		//and if we change it to %s we will get Resource not found exception directly.
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
