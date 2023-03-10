package com.apigatwayservice;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.*;

@SpringBootApplication

public class ApiGatwayApplication {
public static void main(String[] args) {
    SpringApplication.run(ApiGatwayApplication.class,args);
}
}
