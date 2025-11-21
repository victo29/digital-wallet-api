package com.victortavares.geteway;

import com.victortavares.core.domain.TransactionPin;

public interface TransactionPinValidateGateway{

    boolean validate(TransactionPin transactionPin);
}
