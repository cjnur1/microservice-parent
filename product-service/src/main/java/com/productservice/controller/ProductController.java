package com.productservice.controller;

import com.productservice.dto.*;
import com.productservice.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
private final ProductService service;
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public void createProduct(@RequestBody ProductRequest product)
{
service.createProduct(product);
}

@GetMapping
public ResponseEntity<List<ProductRespone>> getProducts()
{
return     service.getProducts();
}
}
