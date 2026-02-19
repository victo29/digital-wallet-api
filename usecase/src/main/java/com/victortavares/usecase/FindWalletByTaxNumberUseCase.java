package com.victortavares.usecase;

import com.victortavares.core.domain.Wallet;
import com.victortavares.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {

    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
