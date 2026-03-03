package com.victortavares.infrastructure.security.service;

import com.victortavares.core.exception.AuthenticateException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.infrastructure.repository.UserEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    public AuthorizationService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userEntityRepository.findByEmail(email);

        if (user == null) throw new UsernameNotFoundException("User not found");

        return user;

    }
}
