package com.yaser.MarsOver.exceptions;

/**
 * @author yasar.yasa
 *
 */
public class WrongDirection extends Exception{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -557419441992890867L;

	public WrongDirection(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongDirection(String message) {
		super(message);
	}
	
}
