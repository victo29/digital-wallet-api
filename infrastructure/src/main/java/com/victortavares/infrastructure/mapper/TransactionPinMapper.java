package com.victortavares.infrastructure.mapper;

import com.victortavares.core.domain.TransactionPin;
import com.victortavares.infrastructure.entity.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {

    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin){
        return new TransactionPinEntity(
                transactionPin.getId(),
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocked()
        );
    }

    public TransactionPinEntity toCreateTransactionPinEntity(TransactionPin transactionPin){
        return new TransactionPinEntity(
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocked()
        );
    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionPinEntity) {
        return new TransactionPin(
            transactionPinEntity.getId(),
            transactionPinEntity.getPin(),
            transactionPinEntity.getAttempt(),
            transactionPinEntity.getBlocked(),
            transactionPinEntity.getCreatedAt(),
            transactionPinEntity.getUpdatedAt()
        );

    }
}
