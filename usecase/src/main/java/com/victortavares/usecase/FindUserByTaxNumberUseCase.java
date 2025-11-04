package com.victortavares.usecase;

import com.victortavares.core.domain.User;

public interface FindUserByTaxNumberUseCase {

    User findByTaxNumber(String TaxNumber);
}
