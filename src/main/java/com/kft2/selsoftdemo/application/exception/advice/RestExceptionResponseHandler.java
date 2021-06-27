package com.kft2.selsoftdemo.application.exception.advice;

import com.kft2.selsoftdemo.application.exception.AbstractCustomRuntimeException;
import com.kft2.selsoftdemo.application.exception.BadRequestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class, RuntimeException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        var response = new ErrorResponse(ex.getMessage());
        var httpStatus = ex instanceof AbstractCustomRuntimeException ? ((AbstractCustomRuntimeException) ex).getHttpStatus() : HttpStatus.INTERNAL_SERVER_ERROR;
        return handleExceptionInternal(ex, response, new HttpHeaders(), httpStatus, request);
    }
}