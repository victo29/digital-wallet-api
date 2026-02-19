package com.victortavares.infrastructure.client;

import com.victortavares.infrastructure.client.dto.response.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiValidateClient", url = "${client.url}")
public interface ApiValidateClient {

    @GetMapping
    ApiValidateResponse validate();
}
