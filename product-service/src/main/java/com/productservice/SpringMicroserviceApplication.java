package com.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.*;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceApplication.class, args);
	}

}
