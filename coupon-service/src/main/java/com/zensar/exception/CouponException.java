package com.zensar.exception;

public class CouponException extends RuntimeException {

	private String message;

	public CouponException() {
		super();
	}

	public CouponException(String message) {
		super(message);
		this.message = message;
	}

}
