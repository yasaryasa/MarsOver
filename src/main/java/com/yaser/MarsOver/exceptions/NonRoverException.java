package com.yaser.MarsOver.exceptions;

/**
 * @author yasar.yasa
 *
 */
public class NonRoverException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4926839722366775465L;

	public NonRoverException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonRoverException(String message) {
		super(message);
	}
	
}
