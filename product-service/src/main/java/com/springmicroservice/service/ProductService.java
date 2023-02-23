package com.springmicroservice.service;

import com.springmicroservice.dto.*;
import com.springmicroservice.model.*;
import com.springmicroservice.repositort.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductService {
private final ProductRepo repo;
public  void createProduct(ProductRequest productRequest)
{
    Product product=Product.builder()
                            .name(productRequest.getName())
                            .description(productRequest.getDescription())
                            .price(productRequest.getPrice())
                            .build();
repo.save(product);
log.info("product {} is saved",product.getId());
}

public ResponseEntity<List<ProductRespone>> getProducts() {
    List<Product> all = repo.findAll();
    List<ProductRespone> list = all.stream()
                                           .map(this::convertTo)
                                           .collect(Collectors.toList());
  return   ResponseEntity.ok(list);

}

private ProductRespone convertTo(Product product)
{
 return    ProductRespone.builder()
                                   .id(product.getId())
                                   .name(product.getName())
                                   .description(product.getDescription())
                                   .price(product.getPrice())
                                   .build();
}
}
