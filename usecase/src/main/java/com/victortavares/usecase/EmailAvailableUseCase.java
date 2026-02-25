package com.victortavares.usecase;

import com.victortavares.core.exception.EmailException;

public interface EmailAvailableUseCase {

    Boolean emailAvaliable(String email) throws EmailException;
}
