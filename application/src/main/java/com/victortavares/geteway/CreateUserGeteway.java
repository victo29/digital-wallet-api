package com.victortavares.geteway;

import com.victortavares.core.domain.User;
import com.victortavares.core.domain.Wallet;

public interface CreateUserGeteway {

    Boolean create(User user, Wallet wallet);

}
