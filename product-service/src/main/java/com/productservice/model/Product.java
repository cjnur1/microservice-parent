package com.productservice.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "products")
public class Product {
@Id
@GeneratedValue(generator = "uuid2")
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
@Column(columnDefinition = "text")
private String id;
private String name;
private String description;
private double price;
}
