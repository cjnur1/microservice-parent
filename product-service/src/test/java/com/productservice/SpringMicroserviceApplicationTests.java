package com.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.dto.*;
import com.productservice.repositort.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.testcontainers.containers.*;
import org.testcontainers.junit.jupiter.*;
import org.testcontainers.junit.jupiter.Container;

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
ProductRepo repo;

@DynamicPropertySource
static void postgresqlProperties(DynamicPropertyRegistry registry) {
	registry.add("spring.datasource.url", postgres::getJdbcUrl);
	registry.add("spring.datasource.password", postgres::getPassword);
	registry.add("spring.datasource.username", postgres::getUsername);
}
@Test
public void shouldRun() throws Exception {
mockMvc.perform(

		MockMvcRequestBuilders.get("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(getProductRequest()))
).andExpect(status().isOk());

}

@Test
public void contextLoads()
{

}

@Test
public void shouldWork() throws Exception {
	mockMvc.perform(
		MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(getProductRequest()))


).andExpect(status().isCreated());
	Assertions.assertEquals(1,
			repo.findAll()
					.size());
}

private ProductRequest getProductRequest() {
	return ProductRequest.builder()
				   .name("i phone 13")
				   .description("i phone 13")
				   .price(1200)
				   .build();
}

}
