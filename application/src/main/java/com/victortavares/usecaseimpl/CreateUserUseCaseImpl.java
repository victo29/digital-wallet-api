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
import com.victortavares.gateway.EncryptorGateway;
import com.victortavares.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserGeteway createUserGeteway;
    private final EncryptorGateway encryptorGateway;

    public CreateUserUseCaseImpl(CreateUserGeteway createUserGeteway, EncryptorGateway encryptorGateway) {
        this.createUserGeteway = createUserGeteway;
        this.encryptorGateway = encryptorGateway;
    }

    @Override
    public void create(User user, TransactionPin pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {

        var encryptedPassword = encryptorGateway.encrypt(user.getPassword());
        user.setPassword(encryptedPassword);
        if(!createUserGeteway.create(user, new Wallet(BigDecimal.ZERO, user, pin))){
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
