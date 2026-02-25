package com.victortavares.usecaseimpl;

import com.victortavares.core.exception.TaxNumberException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.gateway.TaxNumberAvailableGateway;
import com.victortavares.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private final TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvaliable(String taxNumber) throws TaxNumberException {

        if(!taxNumberAvailableGateway.TaxNumberAvailable(taxNumber)){
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        return true;
    }
}
