package com.career.goals.spring.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootLoggingDemoApplication {
	
	Logger log= LoggerFactory.getLogger((SpringBootLoggingDemoApplication.class));

	@GetMapping("/test/{user}")
	public String getResponse(@PathVariable String user) {
		log.debug("Request " +user);
		if(!user.equalsIgnoreCase("test")) {
			throw new RuntimeException();
		}
		
		String response = "Welcome " + user;
		log.debug("response "+response);
		return response;
		
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingDemoApplication.class, args);
	}

}
