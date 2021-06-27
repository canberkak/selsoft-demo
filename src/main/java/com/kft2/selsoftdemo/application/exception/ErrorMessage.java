package com.kft2.selsoftdemo.application.exception;

public enum ErrorMessage {

    TEST("something");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
