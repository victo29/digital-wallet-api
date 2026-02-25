package com.victortavares.gateway;

import com.victortavares.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
