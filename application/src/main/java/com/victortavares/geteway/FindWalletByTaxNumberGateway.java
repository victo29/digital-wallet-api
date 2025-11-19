package com.victortavares.geteway;

import com.victortavares.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findByTaxNumber(String taxNumber);
}
