package com.victortavares.infrastructure.service;

import com.victortavares.gateway.TaxNumberAvailableGateway;
import com.victortavares.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static com.victortavares.infrastructure.utils.Utilities.log;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {

    private final UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean TaxNumberAvailable(String taxNumber) {
        log.info("Verifying if tax number is disponible");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
