package com.victortavares.core.exception;

public class AuthenticateException extends Exception {

    private final String code;

    public AuthenticateException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
