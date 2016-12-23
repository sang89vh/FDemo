package com.ff.fdemo.exception;
public class FieldError {
 
	private String fieldId;
	private String errorCode;
	private String errorMessage;
	private Object[] errorMessageArgs;
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
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
	public Object[] getErrorMessageArgs() {
		return errorMessageArgs;
	}
	public void setErrorMessageArgs(Object[] errorMessageArgs) {
		this.errorMessageArgs = errorMessageArgs;
	}
	
	
}
