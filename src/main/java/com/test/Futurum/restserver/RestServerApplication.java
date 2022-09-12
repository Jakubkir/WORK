package com.test.Futurum.restserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO check if this is necessary
@SpringBootApplication(scanBasePackages = {"com.campaign", "com.example.restserver"})
public class RestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServerApplication.class, args);
	}

}
