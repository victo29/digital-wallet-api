package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.core.exception.InternalServerErrorException;
import com.victortavares.core.exception.TransactionPinException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.gateway.EncryptorGateway;
import com.victortavares.usecase.TransactionPinValidateUseCase;
import com.victortavares.usecase.UpdateTransactionPinUseCase;

import java.util.Objects;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private final UpdateTransactionPinUseCase updateTransactionPinUseCase;
    private final EncryptorGateway encryptorGateway;

    public TransactionPinValidateUseCaseImpl(UpdateTransactionPinUseCase updateTransactionPinUseCase, EncryptorGateway encryptorGateway) {
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
        this.encryptorGateway = encryptorGateway;
    }

    @Override
    public Boolean compare(TransactionPin transactionPin, String pin) throws TransactionPinException, InternalServerErrorException {

        if (transactionPin.getBlocked()) throw  new TransactionPinException(ErrorCodeEnum.TRP0002.getMessage(), ErrorCodeEnum.TRP0002.getCode());

        if(!encryptorGateway.matches(pin, transactionPin.getPin())){
            transactionPin.setAttempt();
            var transactionPinUpdated = updateTransactionPinUseCase.update(transactionPin);
            throw new TransactionPinException(ErrorCodeEnum.trp0003GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.TRP0003.getCode());
        }

        if(transactionPin.getAttempt() < 3){
            transactionPin.restaureAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }
        return true;
    }

    @Override
    public TransactionPin validate(String pin) throws TransactionPinException {

        if (pin.length() != 8) {
            throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
        }

        var encryptedPin = encryptorGateway.encrypt(pin);

        return new TransactionPin(encryptedPin);

    }
}
