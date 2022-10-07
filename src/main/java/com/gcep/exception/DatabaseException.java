package com.gcep.exception;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 3604641968118789794L;
	
	public DatabaseException(String message) {
		super(message);
	}

}
