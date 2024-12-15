package com.harsh.assignment.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Objects;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class AssignmentException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 5460057024243093828L;

	private final String errorCode;
	private final String errorMessage;
	
	private final HttpStatus httpStatus;

}
