package com.orderservice.dto;

import com.orderservice.model.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequest {
private String orderNumber;

private List<OrderItemsListRequest> orderItemsList ;
}
