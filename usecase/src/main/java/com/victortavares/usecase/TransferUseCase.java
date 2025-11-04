package com.victortavares.usecase;

import com.victortavares.core.domain.Transaction;

public interface TransferUseCase {

    Boolean transfer(Transaction transaction);
}
