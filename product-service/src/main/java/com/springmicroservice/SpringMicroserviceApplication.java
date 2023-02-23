package com.springmicroservice;

import com.fasterxml.jackson.databind.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
@Configuration
public class SpringMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceApplication.class, args);
	}

}
