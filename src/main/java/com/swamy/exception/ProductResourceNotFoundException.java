package com.swamy.exception;

public class ProductResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductResourceNotFoundException() {
		super();
	}
	
	public ProductResourceNotFoundException(String message) {
		super(message);
	}
}
