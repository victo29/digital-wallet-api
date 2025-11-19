package com.victortavares.geteway;

import com.victortavares.core.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction create(Transaction transaction);
}
