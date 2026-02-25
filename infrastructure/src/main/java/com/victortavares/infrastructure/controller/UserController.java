package com.victortavares.infrastructure.controller;

import com.victortavares.infrastructure.dto.request.CreateUserRequest;
import com.victortavares.infrastructure.dto.response.BaseResponse;
import com.victortavares.infrastructure.mapper.UserMapper;
import com.victortavares.usecase.CreateUserUseCase;
import com.victortavares.usecase.EmailAvailableUseCase;
import com.victortavares.usecase.TaxNumberAvailableUseCase;
import jakarta.transaction.TransactionalException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.victortavares.infrastructure.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController{

    private final CreateUserUseCase createUserUseCase;
    private final TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private final EmailAvailableUseCase emailAvailableUseCase;
    private final UserMapper  userMapper;

    public UserController(CreateUserUseCase createUserUseCase, TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<String> createUser(@Valid @RequestBody CreateUserRequest request) throws Exception, TransactionalException {
        log.info("Initializing user creation::UserController");
        taxNumberAvailableUseCase.taxNumberAvaliable(request.taxNumber());
        emailAvailableUseCase.emailAvaliable(request.email());
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("User created successfully");
        return BaseResponse.<String>builder().success(true).message("User created successfully").build();
    }
}
