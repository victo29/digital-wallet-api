package com.victortavares.infrastructure.service;

import com.victortavares.core.domain.User;
import com.victortavares.core.domain.Wallet;
import com.victortavares.gateway.CreateUserGeteway;
import com.victortavares.infrastructure.mapper.TransactionPinMapper;
import com.victortavares.infrastructure.mapper.UserMapper;
import com.victortavares.infrastructure.mapper.WalletMapper;
import com.victortavares.infrastructure.repository.TransactionPinEntityRepository;
import com.victortavares.infrastructure.repository.UserEntityRepository;
import com.victortavares.infrastructure.repository.WalletEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import static com.victortavares.infrastructure.utils.Utilities.log;

@Service
@Transactional
public class CreateUserGatewayImpl implements CreateUserGeteway {

    private final UserEntityRepository userEntityRepository;
    private  final UserMapper userMapper;
    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final TransactionPinMapper transactionPinMapper;
    private final WalletEntityRepository walletEntityRepository;
    private final WalletMapper walletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Boolean create(User user, Wallet wallet) {
        try{
            log.info("Initializing creation user::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet ,userSaved, transactionPinSaved));
            log.info("User created successfully::CreateUserGatewayImpl");
            return true;
        }catch (Exception e){
            log.error("There was an error creating the user::CreateUserGatewayImpl");
            return false;
        }
    }
}
