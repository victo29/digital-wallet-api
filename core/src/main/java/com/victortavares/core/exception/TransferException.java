package com.victortavares.core.exception;

public class TransferException extends Exception {

    private final String code;

    public TransferException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
