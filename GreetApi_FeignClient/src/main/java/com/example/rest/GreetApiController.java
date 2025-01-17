package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.WelcomeApiClient;

@RestController
public class GreetApiController {
	
	@Autowired
	private WelcomeApiClient  welcomeApiClient;
	
	@GetMapping("/greet")
	public String greet() {
		
		String welcome = welcomeApiClient.invokeWelcomeMsg();
		String greet =  "Greet api to communicate another microservice using feignclient  :::  ";
		return   greet.concat(welcome);
	}
	
	@GetMapping("/greet2")
	public String greet2() {
		
		
		return "ApiGateWaySecondMethodPath";
		
	
		
	}


}
