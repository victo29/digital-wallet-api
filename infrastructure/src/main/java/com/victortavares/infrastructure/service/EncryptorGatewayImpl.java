package com.victortavares.infrastructure.service;

import com.victortavares.gateway.EncryptorGateway;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptorGatewayImpl implements EncryptorGateway {
    private final PasswordEncoder passwordEncoder;

    public EncryptorGatewayImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encrypt(String value) {
        return passwordEncoder.encode(value);
    }

    @Override
    public boolean matches(String rawValue, String encryptedValue) {
        return passwordEncoder.matches(rawValue, encryptedValue);
    }
}
