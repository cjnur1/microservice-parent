package com.productservice.repositort;

import com.productservice.model.*;
import org.springframework.data.jpa.repository.*;


public interface ProductRepo extends JpaRepository<Product, String> {
}
