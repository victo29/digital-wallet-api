package com.victortavares.usecase;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.core.exception.InternalServerErrorException;

public interface UpdateTransactionPinUseCase {

    TransactionPin update(TransactionPin transactionPin) throws InternalServerErrorException;

}
