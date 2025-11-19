package com.victortavares.geteway;

import com.victortavares.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
