package com.victortavares.core.exception;

public class TaxNumberException extends  Exception{

    public String code;

    public TaxNumberException(String message, String code) {
        super(message);
        this.code = code;
    }
}
