package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.Transaction;
import com.victortavares.gateway.UserNotificationGateway;
import com.victortavares.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {

    private final UserNotificationGateway userNotificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }


    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
