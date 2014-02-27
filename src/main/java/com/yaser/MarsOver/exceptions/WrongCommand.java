package com.yaser.MarsOver.exceptions;

/**
 * @author yasar.yasa
 *
 */
public class WrongCommand extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7159669637604956224L;

	public WrongCommand(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongCommand(String message) {
		super(message);
	}

}
