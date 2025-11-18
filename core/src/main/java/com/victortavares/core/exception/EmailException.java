package com.victortavares.core.exception;

public class EmailException extends  Exception{

    public String code;

    public EmailException(String message, String code) {
        super(message);
        this.code = code;
    }
}
