package com.victortavares.infrastructure.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.victortavares.core.exception.TokenException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;
import com.victortavares.infrastructure.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.expiration}")
    private Long expiration;

    public String generateToken(UserEntity userEntity){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("digital-wallet")
                    .withSubject(userEntity.getEmail())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new TokenException(ErrorCodeEnum.TKN0001.getMessage(), ErrorCodeEnum.TKN0001.getCode());
        }
    }

    public String validateToken(String token){

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("digital-wallet")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new TokenException(ErrorCodeEnum.TKN0002.getMessage(), ErrorCodeEnum.TKN0002.getCode());
        }

    }

    private Instant getExpirationDate(){
        return LocalDateTime.now().plusSeconds(expiration).toInstant(ZoneOffset.of("-03:00"));
    }
}
