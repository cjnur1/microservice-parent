package com.orderservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderservice.dto.*;
import com.orderservice.model.*;
import com.orderservice.repository.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.testcontainers.containers.*;
import org.testcontainers.junit.jupiter.*;
import org.testcontainers.junit.jupiter.Container;

import java.math.*;
import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class SpringMicroserviceApplicationTests {
@Container
static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15");
@Autowired
MockMvc mockMvc;
@Autowired
ObjectMapper mapper;
@Autowired
OrderRepo repo;

@DynamicPropertySource
static void postgresqlProperties(DynamicPropertyRegistry registry) {
	registry.add("spring.datasource.url", postgres::getJdbcUrl);
	registry.add("spring.datasource.password", postgres::getPassword);
	registry.add("spring.datasource.username", postgres::getUsername);
}
	@Test
	void contextLoads() {
	}
	@Test
void shouldAllowInsert() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/order")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(mapToString()))
		).andExpect(status().isCreated());
	}

private OrderResponse mapToString() {
return OrderResponse.builder()
			   .orderNumber("0ne")
			   .id(1l)
			   .orderItemsList(List.of(
					   OrderItemsList.builder()
							   .id(1l)
							   .price(BigDecimal.valueOf(1200))
							   .quantity(20)
							   .build())
			   )
			   .build();
}

}
