package com.victortavares.usecase;

import com.victortavares.core.exception.TaxNumberException;

public interface TaxNumberAvailableUseCase {

    Boolean taxNumberAvaliable(String taxNumber) throws TaxNumberException;
}
