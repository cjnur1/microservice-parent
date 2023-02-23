package com.springmicroservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductRespone {
private String id;
private String name;
private String description;
private double price;
}

