package com.myboxteam.fdemo.exception;
import java.util.ArrayList;
import java.util.List;

public class RestError  {

	private String errorCode;
	private String method;
	private String message;
	private List<FieldError> fieldErrors ;

	

	public RestError() {
		super();
		fieldErrors = new ArrayList<FieldError>();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	

	

}
