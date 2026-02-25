package com.victortavares.infrastructure.dto.request;

import com.victortavares.core.domain.enums.UserTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CreateUserRequest(@NotBlank @Email String email, @NotBlank String password, @NotBlank @CPF String taxNumber, @NotBlank String fullName, @NotNull UserTypeEnum type, @NotBlank @Size(min = 7) String pin) {}
