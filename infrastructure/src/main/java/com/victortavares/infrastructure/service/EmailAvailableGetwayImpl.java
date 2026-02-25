package com.victortavares.infrastructure.service;

import com.victortavares.gateway.EmailAvailableGetway;
import com.victortavares.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailAvailableGetwayImpl implements EmailAvailableGetway {

    private final UserEntityRepository userEntityRepository;

    public EmailAvailableGetwayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return !userEntityRepository.existsByEmail(email);
    }
}
