package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.exception.*;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.gateway.TransferGeteway;
import com.victortavares.usecase.*;

public class TransferUseCaseImpl  implements TransferUseCase {

    private final TransferGeteway transferGeteway;

    public TransferUseCaseImpl(TransferGeteway transferGeteway) {
        this.transferGeteway = transferGeteway;
    }

    @Override
    public Boolean transfer(Transaction transaction) throws Exception {
        transaction.getFromWallet().transfer(transaction.getValue());
        transaction.getToWallet().receiveTransfer(transaction.getValue());
        if(!transferGeteway.transfer(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return true;
    }
}
