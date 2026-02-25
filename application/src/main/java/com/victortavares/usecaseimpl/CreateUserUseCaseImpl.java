package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.core.domain.User;
import com.victortavares.core.domain.Wallet;
import com.victortavares.core.exception.EmailException;
import com.victortavares.core.exception.InternalServerErrorException;
import com.victortavares.core.exception.TaxNumberException;
import com.victortavares.core.exception.TransactionPinException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.gateway.CreateUserGeteway;
import com.victortavares.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserGeteway createUserGeteway;

    public CreateUserUseCaseImpl(CreateUserGeteway createUserGeteway) {
        this.createUserGeteway = createUserGeteway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {

        if(!createUserGeteway.create(user, new Wallet(BigDecimal.ZERO,user, new TransactionPin(pin)))){
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
