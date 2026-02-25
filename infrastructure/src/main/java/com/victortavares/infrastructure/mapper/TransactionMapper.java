package com.victortavares.infrastructure.mapper;

import com.victortavares.core.domain.Transaction;
import com.victortavares.core.domain.enums.TransactionStatusEnum;
import com.victortavares.infrastructure.entity.TransactionEntity;
import com.victortavares.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    private WalletMapper walletMapper;

    public TransactionMapper(WalletMapper walletMapper) {
        this.walletMapper = walletMapper;
    }

    public TransactionEntity toTransactionEntity(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }

    public TransactionEntity createTransaction(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CREATED,
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) throws Exception {
        return  new Transaction(
                transactionEntity.getId(),
                walletMapper.toWallet(transactionEntity.getFromWalletEntity()),
                walletMapper.toWallet(transactionEntity.getToWalletEntity()),
                transactionEntity.getTransactionValue(),
                transactionEntity.getStatus(),
                transactionEntity.getCreateAt(),
                transactionEntity.getUpdateAt()
        );
    }

    public TransactionEntity concludeTransaction(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.SUCCESS,
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }

    public TransactionEntity cancelTransaction(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CANCELED,
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }
}
