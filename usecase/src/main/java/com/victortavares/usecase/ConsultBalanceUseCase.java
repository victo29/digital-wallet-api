package com.victortavares.usecase;

import com.victortavares.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {

    BigDecimal consult(Wallet wallet);
}
