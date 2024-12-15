package com.harsh.assignment.exception;

import lombok.Data;


@Data
public class ErrorResponse {

    private String errorCode;
    private String errorMessage;


}
