package com.swamy.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.swamy.exception.ProductResourceNotFoundException;
import com.swamy.exception.model.ErrorMessage;

@ControllerAdvice
public class ProductCustomExceptionHandler {

	@ExceptionHandler(ProductResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage>errorMessages(){
		
		ErrorMessage errorMessage = ErrorMessage.builder()
				.status(HttpStatus.NOT_FOUND)
				.statusCode(HttpStatus.NOT_FOUND.value())
				.message("Product Data Not Found")
				.build();
		
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}
}