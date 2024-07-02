package com.example.userapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	private String resource;
	private String fieldName;
	private int fieldValue;
	public ResourceNotFoundException(String resource, String fieldName, int fieldValue) {
		super(String.format("%s with %s %s not found", resource, fieldName, fieldValue));
		this.resource = resource;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
