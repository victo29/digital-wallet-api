package com.victortavares.usecase;

import com.victortavares.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {

    Wallet findByTaxNumber(String TaxNumber);
}
