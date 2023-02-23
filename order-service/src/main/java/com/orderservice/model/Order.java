package com.orderservice.model;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.*;

import java.util.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "order_tbl")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String orderNumber;
@OneToMany(cascade = CascadeType.ALL)
private List<OrderItemsList> orderItemsList ;
}
