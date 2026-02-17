package com.victortavares.infrastructure.config;

import com.victortavares.geteway.CreateUserGeteway;
import com.victortavares.geteway.EmailAvailableGetway;
import com.victortavares.geteway.TaxNumberAvailableGateway;
import com.victortavares.usecase.CreateUserUseCase;
import com.victortavares.usecase.EmailAvailableUseCase;
import com.victortavares.usecase.TaxNumberAvailableUseCase;
import com.victortavares.usecaseimpl.CreateUserUseCaseImpl;
import com.victortavares.usecaseimpl.EmailAvailableUseCaseImpl;
import com.victortavares.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGetway emailAvailableGetway){
        return new EmailAvailableUseCaseImpl(emailAvailableGetway);
    }
    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGeteway createUserGeteway){
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGeteway);
    }
}
