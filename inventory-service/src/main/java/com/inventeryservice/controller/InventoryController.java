package com.inventeryservice.controller;

import com.inventeryservice.dto.*;
import com.inventeryservice.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
private final InventoryService service;
@GetMapping
@ResponseStatus(HttpStatus.CREATED)

public List<InventoryResponse> isInventoryAvailable(@RequestParam List<String> skuCode)
{
    return service.isInventoryAvailable(skuCode);
}
}
