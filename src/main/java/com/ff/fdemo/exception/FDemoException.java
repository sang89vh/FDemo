package com.ff.fdemo.exception;
import java.util.List;

public class FDemoException extends BaseException {
	
	private static final long serialVersionUID = 8823356956725033191L;

	public FDemoException(ErrorCodeEnum errorCodeEnum) {
		super();
		this.setErrorCode(errorCodeEnum);
	}
	
	public FDemoException(ErrorCodeEnum errorCodeEnum,List<FieldError> fieldErrors) {
		super();
		this.setErrorCode(errorCodeEnum);
		this.setFieldErrors(fieldErrors);
	}
	


}
