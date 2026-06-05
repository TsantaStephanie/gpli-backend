package com.gpli.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GpliBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpliBackendApplication.class, args);
	}

}
