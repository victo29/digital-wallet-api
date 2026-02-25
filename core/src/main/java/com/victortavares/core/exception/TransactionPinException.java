package com.victortavares.core.exception;

public class TransactionPinException extends Exception {

    private final String code;

    public TransactionPinException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
