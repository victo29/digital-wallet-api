package com.victortavares.usecase;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value , String pin) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, TransactionPinException;

}
