package com.victortavares.usecase;

import com.victortavares.core.domain.User;
import com.victortavares.core.exception.EmailException;
import com.victortavares.core.exception.InternalServerErrorException;
import com.victortavares.core.exception.TaxNumberException;
import com.victortavares.core.exception.TransactionPinException;

public interface CreateUserUseCase {

    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
