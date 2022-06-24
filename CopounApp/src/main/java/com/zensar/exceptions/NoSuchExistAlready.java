package com.zensar.exceptions;

public class NoSuchExistAlready extends RuntimeException {

	private String message;


	public NoSuchExistAlready() {
		super();

	}

	public NoSuchExistAlready(String message) {
		super(message);
		this.message = message;
	}
}
