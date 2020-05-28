package com.stubs.app.exception;

public class MpsServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	public MpsServiceException() {
		super();
	}

	public MpsServiceException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public MpsServiceException(String message, Exception e) {
		super(message, e);
	}

	public MpsServiceException(Exception e) {
		super(e);
	}

	public String getErrorCode() {
		return errorCode;
	}
}
