package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.Wallet;
import com.victortavares.core.exception.NotFoundException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.geteway.FindWalletByTaxNumberGateway;
import com.victortavares.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws NotFoundException {
        var wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);
        if (wallet == null){
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
