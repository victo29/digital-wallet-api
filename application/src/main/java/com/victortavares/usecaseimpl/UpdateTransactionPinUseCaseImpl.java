package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.core.exception.InternalServerErrorException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.gateway.UpdateTransactionPinGateway;
import com.victortavares.usecase.UpdateTransactionPinUseCase;

public class UpdateTransactionPinUseCaseImpl implements UpdateTransactionPinUseCase {

    private final UpdateTransactionPinGateway updateTransactionPinGateway;

    public UpdateTransactionPinUseCaseImpl(UpdateTransactionPinGateway updateTransactionPinGateway) {
        this.updateTransactionPinGateway = updateTransactionPinGateway;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin) throws InternalServerErrorException {
        transactionPin.setAttempt();
        if (!updateTransactionPinGateway.update(transactionPin)){
            throw new InternalServerErrorException(ErrorCodeEnum.TRP0004.getMessage(),ErrorCodeEnum.TRP0004.getCode());
        }
        return transactionPin;
    }
}
