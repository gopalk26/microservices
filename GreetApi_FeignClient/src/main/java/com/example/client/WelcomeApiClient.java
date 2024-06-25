package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="welcome-api")
public interface WelcomeApiClient {
	
	@GetMapping("api/v1/welcome")
	public String invokeWelcomeMsg();

}
