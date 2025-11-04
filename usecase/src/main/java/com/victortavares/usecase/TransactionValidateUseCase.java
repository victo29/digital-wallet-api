package com.victortavares.usecase;

import com.victortavares.core.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction);
}
