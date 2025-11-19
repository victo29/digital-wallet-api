package com.victortavares.geteway;

import com.victortavares.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {
    BigDecimal consult(Wallet wallet);
}
