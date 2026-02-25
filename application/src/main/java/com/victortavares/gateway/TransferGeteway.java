package com.victortavares.gateway;

import com.victortavares.core.domain.Transaction;

public interface TransferGeteway {
    Boolean transfer(Transaction transaction);
}
