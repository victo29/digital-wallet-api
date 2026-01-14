package com.victortavares.infrastructure.mapper;

import com.victortavares.core.domain.Wallet;
import com.victortavares.infrastructure.entity.TransactionPinEntity;
import com.victortavares.infrastructure.entity.UserEntity;
import com.victortavares.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity){
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

}
