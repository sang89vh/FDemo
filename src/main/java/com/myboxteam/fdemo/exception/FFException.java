package com.myboxteam.fdemo.exception;
import java.util.List;

public class FFException extends BaseException {
	
	private static final long serialVersionUID = 8823356956725033191L;

	public FFException(ErrorCodeEnum errorCodeEnum) {
		super();
		this.setErrorCode(errorCodeEnum);
	}
	
	public FFException(ErrorCodeEnum errorCodeEnum,List<FieldError> fieldErrors) {
		super();
		this.setErrorCode(errorCodeEnum);
		this.setFieldErrors(fieldErrors);
	}
	


}
