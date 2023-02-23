package com.orderservice.service;

import com.orderservice.dto.*;
import com.orderservice.model.*;
import com.orderservice.model.OrderItemsList;
import com.orderservice.repository.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

private final OrderRepo repo;
private final OrderItemListRepo itemListRepo;
public void createOrder(OrderRequest request) {
    List<OrderItemsList> orderItemsLists = request.getOrderItemsList()
                                                   .stream()
                                                   .map(p -> mapToRequest(p))
                                                   .toList();
    Order order= Order.builder()
                        .orderNumber(UUID.randomUUID().toString())
                         .orderItemsList(orderItemsLists)
                        .build();
    repo.save(order);
}

private OrderItemsList mapToRequest(OrderItemsListRequest request) {
  return   OrderItemsList.builder()
            .skuCode(request.getSkuCode())
            .price(request.getPrice())
            .quantity(request.getQuantity())
            .build();
}

public List<OrderResponse> getAll() {
    List<Order> all = repo.findAll();
  return   all.stream().map(r->mapToResponse(r)).toList();
}

private OrderResponse mapToResponse(Order r) {
  return   OrderResponse.builder().orderNumber(r.getOrderNumber())
            .orderItemsList(r.getOrderItemsList())
            .id(r.getId())
            .build();
}

public boolean getById(long sku) {
   // return  itemListRepo.findByQuantity(sku).isPresent();
   return  itemListRepo.findById(sku).isPresent();
}
public boolean getBySkuCode(String sku) {
     return  itemListRepo.findBySkuCode(sku).isPresent();

}
}
