package com.orderservice.repository;

import com.orderservice.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface OrderRepo extends JpaRepository<Order,String> {
}
