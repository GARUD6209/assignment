package com.harsh.assignment.exception;

import org.springframework.http.HttpStatus;

import lombok.EqualsAndHashCode;



@EqualsAndHashCode(callSuper=false)
public class AssignmentException extends RuntimeException {

	private static final long serialVersionUID = 5460057024243093828L;

	private final String errorCode;
	private final String errorMessage;
	
	private final HttpStatus httpStatus;

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public AssignmentException(String errorCode, String errorMessage, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

	public AssignmentException(String message, String errorCode, String errorMessage, HttpStatus httpStatus) {
		super(message);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

	public AssignmentException(String message, Throwable cause, String errorCode, String errorMessage, HttpStatus httpStatus) {
		super(message, cause);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

	public AssignmentException(Throwable cause, String errorCode, String errorMessage, HttpStatus httpStatus) {
		super(cause);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

	public AssignmentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode, String errorMessage, HttpStatus httpStatus) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}


}
