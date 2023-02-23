package com.inventeryservice.service;

import com.inventeryservice.repository.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.reactive.function.client.*;

@Service
@RequiredArgsConstructor
public class InventoryService {
private final InventoryRepo repo;
private final WebClient client;
@Transactional(readOnly = true)
public boolean isInventoryAvailable(String sku) {
    Boolean found = client.get()
                            .uri("http://localhost:8091/api/order/"+sku)
                            .retrieve()
                            .bodyToMono(Boolean.class)
                            .block();
    if(found)
    return true;
    else
        return false;
}
}
