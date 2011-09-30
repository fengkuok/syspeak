package com.syspeak.itboss.exception;


public class SecurityException extends RuntimeException {

	private static final long serialVersionUID = 3583566093089790852L;

	public SecurityException() {
		super();
	}

	public SecurityException(String message) {
		super(message);
	}

	public SecurityException(Throwable cause) {
		super(cause);
	}

	public SecurityException(String message, Throwable cause) {
		super(message, cause);
	}
}
