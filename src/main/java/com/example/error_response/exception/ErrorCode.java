package com.example.error_response.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public enum ErrorCode {
    OK(2000, HttpStatus.OK, "OK"),
    CANCLE(4000, HttpStatus.BAD_REQUEST, "CANCLE")
    ;

    @Getter
    private final int code;

    @Getter
    private final HttpStatus httpStatus;

    @Getter
    private final String message;


    ErrorCode(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
