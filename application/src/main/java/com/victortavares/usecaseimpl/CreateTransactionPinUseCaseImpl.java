package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.geteway.CreateTransactionPinGeteway;
import com.victortavares.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {

    private CreateTransactionPinGeteway createTransactionPinGeteway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGeteway createTransactionPinGeteway) {
        this.createTransactionPinGeteway = createTransactionPinGeteway;
    }

    @Override
    public void create(TransactionPin transactionPin) {
        createTransactionPinGeteway.create(transactionPin);
    }
}
