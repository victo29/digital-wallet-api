package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.core.exception.InternalServerErrorException;
import com.victortavares.core.exception.TransactionPinException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.usecase.TransactionPinValidateUseCase;
import com.victortavares.usecase.UpdateTransactionPinUseCase;

import java.util.Objects;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private final UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) throws TransactionPinException, InternalServerErrorException {

        if (transactionPin.getBlocked()) throw  new TransactionPinException(ErrorCodeEnum.TRP0002.getMessage(), ErrorCodeEnum.TRP0002.getCode());

        if(!Objects.equals(pin, transactionPin.getPin())){
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
}
