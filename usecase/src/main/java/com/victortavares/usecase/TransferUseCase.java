package com.victortavares.usecase;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.domain.Wallet;
import com.victortavares.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean transfer(Transaction transaction) throws Exception;

}
