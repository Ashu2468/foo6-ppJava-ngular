package com.stackroute.foodieapp.exceptions;

@SuppressWarnings("serial")
public class RestaurantNotFoundException extends Exception {
	
	public RestaurantNotFoundException(String message) {
		super(message);
	}
}
