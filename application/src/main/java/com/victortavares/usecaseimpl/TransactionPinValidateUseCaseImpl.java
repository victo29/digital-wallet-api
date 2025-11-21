package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.core.exception.TransactionPinException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.geteway.TransactionPinValidateGateway;
import com.victortavares.usecase.TransactionPinValidateUseCase;
import com.victortavares.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private TransactionPinValidateGateway transactionPinValidateGateway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws TransactionPinException {

        if (transactionPin.getBlocked()) throw  new TransactionPinException(ErrorCodeEnum.TRP0002.getMessage(), ErrorCodeEnum.TRP0002.getCode());

        if(!transactionPinValidateGateway.validate(transactionPin)){
            transactionPin.setAttempt();
            var transactionPinUpdated = updateTransactionPinUseCase.update(transactionPin);
            throw new TransactionPinException(ErrorCodeEnum.trp0003GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.TRP0003.getCode());
        }

        if(transactionPin.getAttempt() < 3){
            transactionPin.restaureAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }
        return null;
    }
}
