package com.victortavares.usecase;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.exception.TransferException;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction) throws TransferException;
}
