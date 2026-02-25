package com.victortavares.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String username, String password);
}
