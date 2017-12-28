package com.stackroute.foodieapp.exceptions;

/**
 * exception class
 */
@SuppressWarnings("serial")
public class DuplicateRestaurantFoundException extends Exception {

	/**
	 * constructor for the class
	 */
	public DuplicateRestaurantFoundException(final String message) {
		super(message);
	}
}
