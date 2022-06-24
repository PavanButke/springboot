package com.zensar.exceptions;

public class CopounExistsAlready extends RuntimeException {

	private String message;

	public CopounExistsAlready() {
		super();

	}

	public CopounExistsAlready(String message) {
		super(message);
		this.message = message;
	}

}
