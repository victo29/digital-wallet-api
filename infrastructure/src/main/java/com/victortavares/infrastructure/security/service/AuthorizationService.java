package com.victortavares.infrastructure.security.service;

import com.victortavares.infrastructure.repository.UserEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthorizationService implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    public AuthorizationService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String taxNumber) throws UsernameNotFoundException {
        return userEntityRepository.findByTaxNumber(taxNumber);
    }
}
