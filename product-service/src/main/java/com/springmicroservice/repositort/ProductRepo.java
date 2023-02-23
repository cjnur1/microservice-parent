package com.springmicroservice.repositort;

import com.springmicroservice.model.*;
import org.springframework.data.jpa.repository.*;


public interface ProductRepo extends JpaRepository<Product, String> {
}
