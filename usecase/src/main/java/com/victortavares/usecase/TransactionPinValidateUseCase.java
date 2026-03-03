package com.victortavares.usecase;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.core.exception.InternalServerErrorException;
import com.victortavares.core.exception.TransactionPinException;

public interface TransactionPinValidateUseCase {
    Boolean compare(TransactionPin transactionPin, String pin) throws TransactionPinException, InternalServerErrorException;

    TransactionPin validate(String pin) throws TransactionPinException;
}
