package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/")
public class WelcomeController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String welcome() {
		
		String port = env.getProperty("server.port");
		return "rest api can communicate with micro service"+" PortNo   :: " + (port)+"   ";
	}
	
	@GetMapping("/welcome2")
	public String welcome2() {
		
		
		return "rest api can communicate PathAndMethod2 ";
	}
	
	
	@GetMapping("/welcome3")
	public String welcome3() {
		
		String port = env.getProperty("server.port");
		return "rest api can communicate with micro service"+" PortNo   :: " + (port)+"   ";
	}
	
	

}
