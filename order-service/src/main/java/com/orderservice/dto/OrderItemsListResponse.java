package com.orderservice.dto;

import com.orderservice.model.*;
import lombok.*;

import java.math.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderItemsListResponse {
private Long id;
private String skuCode;
private BigDecimal price;
private Integer quantity;

}
