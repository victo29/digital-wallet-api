package com.victortavares.geteway;

import com.victortavares.core.domain.Transaction;

public interface TransactionValidateGateway {
    Boolean validate(Transaction transaction);
}
