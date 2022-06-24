package com.zensar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zensar.entity.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandling {

	

	@ExceptionHandler(value = NoSuchExistAlready.class )
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleException(NoSuchExistAlready ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler(value =  CopounExistsAlready.class)
	@ResponseStatus
	public @ResponseBody ErrorResponse handleException(CopounExistsAlready ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
}
