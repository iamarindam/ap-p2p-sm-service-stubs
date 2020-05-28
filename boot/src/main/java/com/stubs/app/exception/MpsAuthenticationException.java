package com.stubs.app.exception;

/*
 *
 * @Author: Apeksha Ubhayakar
 * @Date: 21-10-2019
 *
 */

public class MpsAuthenticationException extends RuntimeException  {

    private static final long serialVersionUID = 1L;
    private String errorCode;

    public MpsAuthenticationException() {
        super();
    }

    public MpsAuthenticationException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public MpsAuthenticationException(String message, Exception e) {
        super(message, e);
    }

    public MpsAuthenticationException(Exception e) {
        super(e);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
