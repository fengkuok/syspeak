package com.syspeak.itboss.exception;


public class CmsException extends RuntimeException {

	private static final long serialVersionUID = 3583566093089790852L;

	public CmsException() {
		super();
	}

	public CmsException(String message) {
		super(message);
	}

	public CmsException(Throwable cause) {
		super(cause);
	}

	public CmsException(String message, Throwable cause) {
		super(message, cause);
	}
}

