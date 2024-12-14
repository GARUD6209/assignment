package com.harsh.assignment.constant;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {
    
	GENERIC_ERROR("2000","Unable To Process, try later"),
	USER_ALDEADY_EXIST("20001", "Invalid Request, User already exist."),
	TXN_STATUS_HANDLER_NOT_CONFIGURED("20002", "StatusHandler not configured, Try again later."),
	DUPLICATE_TXN_REF("20003", "Invalid txnRefernce, Duplicate key");
	

	private String errorCode;
	private String errorMessage;

	ErrorCodeEnum(String errorCode, String errorMessage) {
		 this.errorCode = errorCode;
	     this.errorMessage = errorMessage;
	}

	public static ErrorCodeEnum fromErrorCode(String errorCode) {
		for (ErrorCodeEnum error : ErrorCodeEnum.values()) {
			if (error.getErrorCode().equals(errorCode)) {
				return error;
			}
		}
		throw new IllegalArgumentException("No matching enum constant for errorCode: " + errorCode);
	}

	public static ErrorCodeEnum fromErrorMessage(String errorMessage) {
		for (ErrorCodeEnum error : ErrorCodeEnum.values()) {
			if (error.getErrorMessage().equalsIgnoreCase(errorMessage)) {
				return error;
			}
		}
		throw new IllegalArgumentException("No matching enum constant for errorMessage: " + errorMessage);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
