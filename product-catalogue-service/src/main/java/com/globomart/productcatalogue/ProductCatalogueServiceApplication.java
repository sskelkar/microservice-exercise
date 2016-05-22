package com.globomart.productcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ProductCatalogueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueServiceApplication.class, args);
	}
}
