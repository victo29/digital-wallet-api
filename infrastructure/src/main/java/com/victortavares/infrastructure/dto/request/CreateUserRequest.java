package com.victortavares.infrastructure.dto.request;

import com.victortavares.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullName, UserTypeEnum type, String pin) {}
