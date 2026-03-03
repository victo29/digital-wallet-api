package com.victortavares.infrastructure.controller;

import com.victortavares.infrastructure.dto.request.AuthenticationRequest;
import com.victortavares.infrastructure.dto.response.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<String> login(@RequestBody @Valid AuthenticationRequest authenticationRequest){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationRequest.email(), authenticationRequest.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        return BaseResponse.<String>builder().success(true).message("User successfully authenticated").build();
    }
}
