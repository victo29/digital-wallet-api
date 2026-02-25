package com.victortavares.infrastructure.service;

import com.victortavares.core.domain.Transaction;
import com.victortavares.gateway.TransactionValidateGateway;
import com.victortavares.infrastructure.client.ApiValidateService;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {

    private final ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        var response = apiValidateService.validate();
        if (response == null){
            return false;
        }
        return response.success();
    }
}
