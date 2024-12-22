package com.ecom.custom_exceptions;

public class ApiException extends RuntimeException {
	public ApiException(String errMesg) {
		super(errMesg);
	}
}
