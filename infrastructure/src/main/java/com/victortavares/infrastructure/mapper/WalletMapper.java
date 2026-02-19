package com.victortavares.infrastructure.mapper;

import com.victortavares.core.domain.Wallet;
import com.victortavares.infrastructure.entity.TransactionPinEntity;
import com.victortavares.infrastructure.entity.UserEntity;
import com.victortavares.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    private TransactionPinMapper transactionPinMapper;
    private UserMapper userMapper;

    public WalletMapper(TransactionPinMapper transactionPinMapper, UserMapper userMapper) {
        this.transactionPinMapper = transactionPinMapper;
        this.userMapper = userMapper;
    }

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity){
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public Wallet toWallet(WalletEntity walletEntity) throws Exception {
        if (walletEntity == null){
            return null;
        }

        return new Wallet(
            walletEntity.getId(),
            walletEntity.getBalance(),
            userMapper.toUser(walletEntity.getUserEntity()),
            walletEntity.getCreateAt(),
            walletEntity.getUpdateAt(),
            transactionPinMapper.toTransactionPin(walletEntity.getTransactionPinEntity())
        );
    }

}
