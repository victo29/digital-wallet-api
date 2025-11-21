package com.victortavares.usecase;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.core.exception.TransactionPinException;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin) throws TransactionPinException;
}
