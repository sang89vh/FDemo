package com.ff.fdemo.exception;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ErrorCodeEnumImpl implements ErrorCodeEnum {

	UNKNOWN_ERROR("UNKNOWN_ERROR","fdemo.exception.message.unknown_error"), 
	INVALID_PARAMS("INVALID_PARAMS","fdemo.exception.message.invalid_params"),
	// FIXME: add more here

	;

	// lookup table to be used to find enum for conversion
	private static final Map<String, ErrorCodeEnumImpl> lookup = new HashMap<String, ErrorCodeEnumImpl>();

	static {
		for (ErrorCodeEnumImpl e : EnumSet.allOf(ErrorCodeEnumImpl.class))
			lookup.put(e.getErrorCode(), e);
	}

	private String errorCode;

	private String messageCode;

	

	ErrorCodeEnumImpl(String errorCode, String messageCode) {
		this.errorCode = errorCode;
		this.messageCode = messageCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public static ErrorCodeEnumImpl get(String errorCode) {
		return lookup.get(errorCode);
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getMessageCode() {
		return messageCode;
	}


}
