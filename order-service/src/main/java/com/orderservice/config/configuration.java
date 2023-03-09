package com.orderservice.config;

import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.client.*;

@Configuration
public class configuration {

@Bean
@LoadBalanced
public WebClient.Builder webClient()
{
    return WebClient.builder();
}
}
