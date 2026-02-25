package com.victortavares.usecaseimpl;

import com.victortavares.core.exception.EmailException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.gateway.EmailAvailableGetway;
import com.victortavares.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private final EmailAvailableGetway emailAvailableGetway;

    public EmailAvailableUseCaseImpl(EmailAvailableGetway emailAvailableGetway) {
        this.emailAvailableGetway = emailAvailableGetway;
    }

    @Override
    public Boolean emailAvaliable(String email) throws EmailException {

        if(!emailAvailableGetway.emailAvailable(email)){
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        return true;
    }
}
