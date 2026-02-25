package com.victortavares.infrastructure.service;

import com.victortavares.core.domain.Transaction;
import com.victortavares.gateway.UserNotificationGateway;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return true;
    }
}
