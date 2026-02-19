package com.victortavares.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DigitalWalletApi {

    public static void main(String[] args){
        SpringApplication.run(DigitalWalletApi.class, args);
    }
}
