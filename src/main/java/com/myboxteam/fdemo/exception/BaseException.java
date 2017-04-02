package com.myboxteam.fdemo.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;


public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -7030732749416640448L;
	protected String message;
	protected ErrorCodeEnum errorCode;

	private List<FieldError> fieldErrors;

	public BaseException() {

		fieldErrors = new ArrayList<FieldError>();
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorCodeEnum getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodeEnum errorCode) {
		this.errorCode = errorCode;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public List<FieldError> addFieldError(String fieldId, String errorCode,
			String errorMessageKey) {

		FieldError fieldError = new FieldError();
		fieldError.setFieldId(fieldId);
		fieldError.setErrorCode(errorCode);
		fieldError.setErrorMessage(errorMessageKey);

		fieldErrors.add(fieldError);

		return fieldErrors;
	}

	public List<FieldError> addFieldError(String fieldId, String errorCode,
			String errorMessageKey, Object[] errorMessageArgs) {

		FieldError fieldError = new FieldError();
		fieldError.setFieldId(fieldId);
		fieldError.setErrorCode(errorCode);
		fieldError.setErrorMessage(errorMessageKey);
		fieldError.setErrorMessageArgs(errorMessageArgs);

		fieldErrors.add(fieldError);

		return fieldErrors;
	}

	public RestError transformToRestError(MessageSource messageSource,
			Locale locale, String method) {

		RestError restError = new RestError();

		restError.setMethod(method);
		restError.setErrorCode(errorCode.getErrorCode());
		restError.setMessage(messageSource.getMessage(
				errorCode.getMessageCode(), null, locale));

		for (FieldError fieldError : fieldErrors) {
			Object[] args = fieldError.getErrorMessageArgs();
			String messageCode = fieldError.getErrorMessage();

			messageCode = messageCode.replace("{", "").replace("}", "");

			String message = messageSource
					.getMessage(messageCode, args, locale);
			fieldError.setErrorMessage(message);
		}
		restError.setFieldErrors(fieldErrors);
		return restError;
	}

}
