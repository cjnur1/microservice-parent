package com.inventeryservice.repository;

import com.inventeryservice.model.*;
import org.springframework.data.jpa.repository.*;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {
}
