package com.inventeryservice;

import com.inventeryservice.model.*;
import com.inventeryservice.repository.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.client.*;

@SpringBootApplication
public class InventeryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventeryServiceApplication.class, args);
	}

	@Bean
public WebClient getWebClient()
	{
		return  WebClient.create();
	}

	@Bean
public CommandLineRunner load(InventoryRepo repo)
	{
		return args -> {
			Inventory inv1 = Inventory.builder()
									 .skuCode("iphone 12")
									 .quantity(12)
									 .build();
			Inventory inv2 = Inventory.builder()
									 .skuCode("tablet")
									 .quantity(2)
									 .build();
			repo.save(inv1);
			repo.save(inv2);
		};
	}
}
