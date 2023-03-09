package com.inventeryservice.repository;

import com.inventeryservice.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {
List<Inventory> findBySkuCodeIn(List<String> skuCode);
//Optional<Inventory> findBySkuCode(List<String> sku);
}
