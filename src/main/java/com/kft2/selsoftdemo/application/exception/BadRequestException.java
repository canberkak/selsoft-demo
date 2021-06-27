package com.kft2.selsoftdemo.application.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends AbstractCustomRuntimeException {

    public BadRequestException(ErrorMessage errorMessage) {
        super(errorMessage,HttpStatus.BAD_REQUEST);
    }
}