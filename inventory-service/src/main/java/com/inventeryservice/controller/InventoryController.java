package com.inventeryservice.controller;

import com.inventeryservice.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
private final InventoryService service;
@GetMapping("/{sku}")
@ResponseStatus(HttpStatus.CREATED)
public boolean isInventoryAvailable(@PathVariable String sku)
{
    return service.isInventoryAvailable(sku);
}
}
