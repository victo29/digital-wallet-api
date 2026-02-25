package com.victortavares.core.exception;

public class BadRequestException extends Exception {

    private final String code;

    public BadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
