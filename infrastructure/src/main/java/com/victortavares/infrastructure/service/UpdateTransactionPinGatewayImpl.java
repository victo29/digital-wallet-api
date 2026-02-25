package com.victortavares.infrastructure.service;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.gateway.UpdateTransactionPinGateway;
import com.victortavares.infrastructure.mapper.TransactionPinMapper;
import com.victortavares.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransactionPinGatewayImpl implements UpdateTransactionPinGateway {

    private final TransactionPinMapper transactionPinMapper;
    private final TransactionPinEntityRepository transactionPinEntityRepository;

    public UpdateTransactionPinGatewayImpl(TransactionPinMapper transactionPinMapper, TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinMapper = transactionPinMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public Boolean update(TransactionPin transactionPin) {
        try {
            transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(transactionPin));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
