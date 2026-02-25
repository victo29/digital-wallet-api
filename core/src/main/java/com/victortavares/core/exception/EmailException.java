package com.victortavares.core.exception;

public class EmailException extends  Exception{

    public final String code;

    public EmailException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
