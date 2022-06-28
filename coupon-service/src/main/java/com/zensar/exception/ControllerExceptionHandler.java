package com.zensar.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(CouponException.class)
	public ResponseEntity<Object> resourceNotFoundException(CouponException ex, WebRequest request) {
		ErrorResponse message = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", message);
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorResponse message = new ErrorResponse(HttpStatus.BAD_GATEWAY.value(), ex.getMessage());
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", message);
		body.put("global message", "This is a global error");

		return new ResponseEntity<Object>(body, HttpStatus.BAD_GATEWAY);
	}

}
