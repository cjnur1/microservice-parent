package com.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "orderitemslist_tbl")
@Entity
public class OrderItemsList {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String skuCode;
@NonNull
private BigDecimal price;
private Integer quantity;

}
