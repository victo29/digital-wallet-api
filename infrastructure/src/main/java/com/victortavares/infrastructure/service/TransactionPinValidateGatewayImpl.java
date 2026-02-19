package com.victortavares.infrastructure.service;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.geteway.TransactionPinValidateGateway;
import com.victortavares.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    private TransactionPinEntityRepository transactionPinEntityRepository;

    @Override
    public boolean validate(TransactionPin transactionPin) {
        var transactionPinSaved = transactionPinEntityRepository.findById(transactionPin.getId());
        if(transactionPinSaved.isEmpty()){
            return false;
        }

        if(transactionPinSaved.get().getPin() != transactionPin.getPin()){
            return false;
        }

        return true;
    }
}
