package com.victortavares.infrastructure.controller;

import com.victortavares.infrastructure.dto.request.CreateUserRequest;
import com.victortavares.infrastructure.dto.response.BaseResponse;
import com.victortavares.infrastructure.mapper.UserMapper;
import com.victortavares.usecase.CreateUserUseCase;
import jakarta.transaction.TransactionalException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.victortavares.infrastructure.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController{

    private CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception, TransactionalException {
        log.info("Initializing user creation::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("User created successfully");
        return BaseResponse.<String>builder().success(true).message("User created successfully").build();
    }
}
