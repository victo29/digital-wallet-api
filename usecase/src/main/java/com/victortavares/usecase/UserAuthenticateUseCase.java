package com.victortavares.usecase;

import com.victortavares.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {

    Boolean authenticate(String username, String password) throws AuthenticateException;
}
