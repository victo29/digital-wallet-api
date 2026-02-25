package com.victortavares.infrastructure.service;

import com.victortavares.core.domain.Transaction;
import com.victortavares.gateway.CreateTransactionGateway;
import com.victortavares.infrastructure.mapper.TransactionMapper;
import com.victortavares.infrastructure.repository.TransactionEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {

    private final TransactionEntityRepository transactionEntityRepository;
    private final TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction) throws Exception {
       try {
           var transactionEntity = transactionMapper.createTransaction(transaction);
           return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
       }catch (Exception e){
           throw e;
       }
    }
}
