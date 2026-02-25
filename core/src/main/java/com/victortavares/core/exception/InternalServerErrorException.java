package com.victortavares.core.exception;

public class InternalServerErrorException extends Exception {

    private final String code;

    public InternalServerErrorException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
