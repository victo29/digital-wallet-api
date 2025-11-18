package com.victortavares.usecaseimpl;

import com.victortavares.geteway.EmailAvailableGetway;
import com.victortavares.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private EmailAvailableGetway emailAvailableGetway;

    public EmailAvailableUseCaseImpl(EmailAvailableGetway emailAvailableGetway) {
        this.emailAvailableGetway = emailAvailableGetway;
    }

    @Override
    public Boolean emailAvaliable(String email) {
        return emailAvailableGetway.emailAvailable(email);
    }
}
