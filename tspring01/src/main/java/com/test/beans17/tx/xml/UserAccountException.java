package com.test.beans17.tx.xml;

public class UserAccountException extends RuntimeException{

	public UserAccountException() {
		super();
	}

	public UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserAccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAccountException(String message) {
		super(message);
	}

	public UserAccountException(Throwable cause) {
		super(cause);
	}
	
}
