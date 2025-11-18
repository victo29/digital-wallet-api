package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.core.domain.User;
import com.victortavares.core.domain.Wallet;
import com.victortavares.core.exception.EmailException;
import com.victortavares.core.exception.TaxNumberException;
import com.victortavares.core.exception.TransactionPinException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.geteway.CreateUserGeteway;
import com.victortavares.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {


    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;

    private EmailAvailableUseCase emailAvailableUseCase;

    private CreateWalletUseCase createWalletUseCase;

    private CreateTransactionPinUseCase createTransactionPinUseCase;

    private CreateUserGeteway createUserGeteway;


    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateWalletUseCase createWalletUseCase, CreateTransactionPinUseCase transactionPinUseCase, CreateTransactionPinUseCase createTransactionPinUseCase, CreateUserGeteway createUserGeteway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createWalletUseCase = createWalletUseCase;
        this.createTransactionPinUseCase = createTransactionPinUseCase;
        this.createUserGeteway = createUserGeteway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException {
        if(taxNumberAvailableUseCase.taxNumberAvaliable(user.getTaxNumber().getValue())){
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if(!emailAvailableUseCase.emailAvaliable(user.getEmail())){
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        var userSaved = createUserGeteway.create(user);

        createWalletUseCase.create(new Wallet(BigDecimal.ZERO, userSaved));
        createTransactionPinUseCase.create(new TransactionPin(userSaved, pin));
    }
}
