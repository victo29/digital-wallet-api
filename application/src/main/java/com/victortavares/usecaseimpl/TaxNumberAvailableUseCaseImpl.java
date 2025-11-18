package com.victortavares.usecaseimpl;

import com.victortavares.geteway.TaxNumberAvailableGateway;
import com.victortavares.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvaliable(String taxNumber) {
        return taxNumberAvailableGateway.TaxNumberAvailable(taxNumber);
    }
}
