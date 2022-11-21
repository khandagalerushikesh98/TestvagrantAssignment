package com.testvagrant.exceptions;

public class InputMismatchException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;        //Default serial version UID
	String message;

	public InputMismatchException() {}
	

	public InputMismatchException(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "InputMismatchException [message=" + message + "]";
	}
}
