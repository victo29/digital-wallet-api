package com.victortavares.infrastructure.service;

import com.victortavares.core.domain.Wallet;
import com.victortavares.gateway.FindWalletByTaxNumberGateway;
import com.victortavares.infrastructure.mapper.WalletMapper;
import com.victortavares.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {

    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        return  walletMapper.toWallet( walletEntityRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
