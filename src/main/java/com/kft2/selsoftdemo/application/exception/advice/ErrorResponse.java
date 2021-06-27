package com.kft2.selsoftdemo.application.exception.advice;

import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
public class ErrorResponse {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @NonNull
    private String errorMessage;

    private String timestamp = sdf.format(new Timestamp(System.currentTimeMillis()));
}