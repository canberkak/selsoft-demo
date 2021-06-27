package com.kft2.selsoftdemo.application.exception;

import org.springframework.http.HttpStatus;

public class AbstractCustomRuntimeException extends RuntimeException {

    private final HttpStatus httpStatus;

    public AbstractCustomRuntimeException(ErrorMessage errorMessage, HttpStatus httpStatus) {
        super(errorMessage.getErrorMessage());
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}