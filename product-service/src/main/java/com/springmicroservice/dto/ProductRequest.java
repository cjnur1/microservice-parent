package com.springmicroservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductRequest {
private String name;
private String description;
private double price;
}

