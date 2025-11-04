package com.victortavares.usecase;

import com.victortavares.core.domain.Transaction;

public interface CreateTransactionUseCase {
    void create(Transaction transaction);
}
