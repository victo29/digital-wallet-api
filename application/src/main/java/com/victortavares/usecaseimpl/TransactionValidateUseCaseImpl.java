package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.exception.TransferException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.geteway.TransactionValidateGateway;
import com.victortavares.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {

    private TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if (!transactionValidateGateway.validate(transaction)){
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }
        return true;
    }

}
