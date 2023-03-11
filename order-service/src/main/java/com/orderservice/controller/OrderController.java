package com.orderservice.controller;

import com.orderservice.dto.*;
import com.orderservice.service.*;
import io.github.resilience4j.circuitbreaker.annotation.*;
import io.github.resilience4j.retry.annotation.*;
import io.github.resilience4j.timelimiter.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

@Autowired
OrderService service;
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
@CircuitBreaker(name = "inventory",fallbackMethod = "fallBackMethod")
@TimeLimiter(name = "inventory")
@Retry(name = "inventory")
public CompletableFuture<String> createOrder(@RequestBody OrderRequest request)
{
    return  CompletableFuture.supplyAsync(()->service.createOrder(request));
}

public CompletableFuture<String> fallBackMethod(OrderRequest request, RuntimeException exception)
{
    return CompletableFuture.supplyAsync(()->"this is fallbackmethod plz try again");
}

@GetMapping
@ResponseStatus(HttpStatus.OK)
public List<OrderResponse> getAll()
{
    return service.getAll();
}



@GetMapping("/{sku}")
@ResponseStatus(HttpStatus.OK)
public boolean getBySkuCode(@PathVariable String sku)
{
    return service.getBySkuCode(sku);
}
}