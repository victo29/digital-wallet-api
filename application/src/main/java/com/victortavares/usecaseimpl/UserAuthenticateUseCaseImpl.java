package com.victortavares.usecaseimpl;

import com.victortavares.core.exception.AuthenticateException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.geteway.UserAuthenticateGateway;
import com.victortavares.usecase.UserAuthenticateUseCase;


public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {
        if(!userAuthenticateGateway.authenticate(username, password)){
          throw new AuthenticateException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }

        return true;
    }

}
