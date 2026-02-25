package com.victortavares.gateway;

import com.victortavares.core.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction create(Transaction transaction) throws Exception;
}
