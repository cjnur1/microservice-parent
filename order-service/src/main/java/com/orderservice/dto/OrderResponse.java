package com.orderservice.dto;

import com.orderservice.model.OrderItemsList;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponse {
private Long id;
private String orderNumber;
private List<OrderItemsList> orderItemsList ;
}
