package com.inventeryservice.service;

import com.inventeryservice.dto.*;
import com.inventeryservice.model.*;
import com.inventeryservice.repository.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.reactive.function.client.*;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class InventoryService {
private final InventoryRepo repo;
private final WebClient client;
@Transactional(readOnly = true)
public List<InventoryResponse> isInventoryAvailable(List<String> sku) {
    System.out.println(sku);
    List<Inventory> all = repo.findBySkuCodeIn(sku);
    List<InventoryResponse> inventoryResponses = all
                                                         .stream()
                                                         .map(inventory ->
                                                                      InventoryResponse.builder()
                                                                              .skuCode(inventory.getSkuCode())
                                                                              .isInStock(inventory.getQuantity() > 0)
                                                                              .quantity(inventory.getQuantity())
                                                                              .build()
                                                         )
                                                         .toList();
    System.out.println("--------"+inventoryResponses);
    return inventoryResponses;

}
}
