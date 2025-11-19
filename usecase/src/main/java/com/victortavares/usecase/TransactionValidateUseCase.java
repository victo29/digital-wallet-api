package com.victortavares.usecase;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.exception.TransferException;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction) throws TransferException;
}
