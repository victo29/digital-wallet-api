package com.victortavares.gateway;

public interface EncryptorGateway {

    String encrypt(String value);

    boolean matches(String rawValue, String encryptedValue);
}
