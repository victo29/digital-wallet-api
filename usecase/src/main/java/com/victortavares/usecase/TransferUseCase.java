package com.victortavares.usecase;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.exception.InternalServerErrorException;
import com.victortavares.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException;

}
