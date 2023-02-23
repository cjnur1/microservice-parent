package com.orderservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderItemsListRequest {
private String skuCode;
private BigDecimal price;
private Integer quantity;


}
