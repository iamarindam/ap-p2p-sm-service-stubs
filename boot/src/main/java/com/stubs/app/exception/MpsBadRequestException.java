package com.stubs.app.exception;

/*
 *
 * @Author: Apeksha Ubhayakar
 * @Date: 21-10-2019
 *
 */

public class MpsBadRequestException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String errorCode;

    public MpsBadRequestException() {
        super();
    }

    public MpsBadRequestException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public MpsBadRequestException(String message, Exception e) {
        super(message, e);
    }

    public MpsBadRequestException(Exception e) {
        super(e);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
