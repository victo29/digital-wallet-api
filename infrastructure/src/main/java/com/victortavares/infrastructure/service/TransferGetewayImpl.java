package com.victortavares.infrastructure.service;

import com.victortavares.core.domain.Transaction;
import com.victortavares.gateway.TransferGeteway;
import com.victortavares.infrastructure.mapper.TransactionMapper;
import com.victortavares.infrastructure.mapper.WalletMapper;
import com.victortavares.infrastructure.repository.TransactionEntityRepository;
import com.victortavares.infrastructure.repository.WalletEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransferGetewayImpl implements TransferGeteway {

    private final WalletMapper walletMapper;
    private final TransactionMapper transactionMapper;
    private final WalletEntityRepository walletEntityRepository;
    private final TransactionEntityRepository transactionEntityRepository;

    public TransferGetewayImpl(WalletMapper walletMapper, TransactionMapper transactionMapper, WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository) {
        this.walletMapper = walletMapper;
        this.transactionMapper = transactionMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        try {
            walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getFromWallet()));
            walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getToWallet()));
            transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));
            return true;
        }catch (Exception e) {
            transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
            return false;
        }
    }
}
