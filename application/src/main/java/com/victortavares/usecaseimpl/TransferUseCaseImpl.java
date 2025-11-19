package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.domain.Wallet;
import com.victortavares.core.exception.InternalServerErrorException;
import com.victortavares.core.exception.TransferException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.geteway.TransferGeteway;
import com.victortavares.usecase.CreateTransactionUseCase;
import com.victortavares.usecase.FindWalletByTaxNumberUseCase;
import com.victortavares.usecase.TransactionValidateUseCase;
import com.victortavares.usecase.TransferUseCase;

import java.math.BigDecimal;

public class TransferUseCaseImpl  implements TransferUseCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferGeteway transferGeteway;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGeteway transferGeteway) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGeteway = transferGeteway;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        from.transfer(value);
        to.receiveTransfer(value);

        var transaction = createTransactionUseCase.create(new Transaction(from,to, value));

        transactionValidateUseCase.validate(transaction);

        if(!transferGeteway.transfer(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return true;
    }
}
