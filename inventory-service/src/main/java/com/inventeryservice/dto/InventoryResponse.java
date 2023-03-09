package com.inventeryservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
private String skuCode;
private boolean isInStock;
private  int quantity;
}
