package com.orderservice.controller;

import com.orderservice.dto.*;
import com.orderservice.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

@Autowired
OrderService service;
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public void createOrder(@RequestBody OrderRequest request)
{
    service.createOrder(request);
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