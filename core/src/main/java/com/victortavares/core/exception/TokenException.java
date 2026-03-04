package com.victortavares.core.exception;

public class TokenException extends RuntimeException {
    private final String code;

    public TokenException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
