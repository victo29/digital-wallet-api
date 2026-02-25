package com.victortavares.usecase;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.domain.Wallet;
import com.victortavares.core.exception.TransferException;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {
    Transaction create(Wallet toWallet, Wallet fromWallet, BigDecimal value) throws Exception;
}
