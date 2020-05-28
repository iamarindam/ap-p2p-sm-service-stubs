package com.stubs.app.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stubs.app.exception.MpsAuthenticationException;
import com.stubs.app.exception.MpsBadRequestException;
import com.stubs.app.exception.MpsServiceException;
import com.stubs.app.model.mps.ErrorResponse;
import com.stubs.app.model.mps.Errors;
import com.stubs.app.model.mps.LookUpResponse;

@ControllerAdvice
public class CustomGlobalExceptionHandler  {

    //400 - Bad request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public LookUpResponse processFieldValidationError() {
    	
    	LookUpResponse lokResp = new LookUpResponse();
    	
        Errors response = new Errors();
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonStr = "{\"errors\":{\"error\": [{\"source\": \"Request data validation\",\"reasonCode\": 602,\"description\": \"Structural validation failure\",\"recoverable\": true,\"details\":[{\"name\": \"string\",\"value\": \"string\"}]}]}}";
            response =  mapper.readValue(jsonStr, Errors.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        lokResp.setErrors(response);
        return lokResp;
    }

    //401 - Authentication
    @ExceptionHandler(MpsAuthenticationException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public LookUpResponse processAuthenticationError() {
    	
    	LookUpResponse lokResp = new LookUpResponse();
    	
        Errors response = new Errors();
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonStr = "{\"errors\":{\"error\": [{\"source\": \"Authentication validation\",\"reasonCode\": 601,\"description\": \"Authentication failure\",\"recoverable\": true,\"details\":[{\"name\": \"string\",\"value\": \"string\"}]}]}}";
            response =  mapper.readValue(jsonStr, Errors.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        lokResp.setErrors(response);
        return lokResp;
    }

    //403 - Participant is retired


    //406 - Not Acceptable
    @ExceptionHandler(MpsBadRequestException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> processNotAcceptableError() {
        ErrorResponse response = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonStr = "{\"errors\":{\"error\": [{\"source\": \"Not Acceptable\",\"reasonCode\": 101,\"description\": \"Not Acceptable\",\"recoverable\": true,\"details\":[{\"name\": \"string\",\"value\": \"string\"}]}]}}";
            response =  mapper.readValue(jsonStr, ErrorResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    // 415 - Unsupported Media Type
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ResponseEntity<ErrorResponse> processHttpMediaTypeError() {
        ErrorResponse response = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonStr = "{\"errors\":{\"error\": [{\"source\": \"Not supported Media Type\",\"reasonCode\": 102,\"description\": \"Not supported Media Type\",\"recoverable\": true,\"details\":[{\"name\": \"string\",\"value\": \"string\"}]}]}}";
            response =  mapper.readValue(jsonStr, ErrorResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    // 500 - Internal server error
    @ExceptionHandler(MpsServiceException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> processInternalServerError() {
        ErrorResponse response = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonStr = "{\"errors\":{\"error\": [{\"source\": \"Internal Server Error\",\"reasonCode\": 915,\"description\": \"Operation failed\",\"recoverable\": true,\"details\":[{\"name\": \"string\",\"value\": \"string\"}]}]}}";
            response =  mapper.readValue(jsonStr, ErrorResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
