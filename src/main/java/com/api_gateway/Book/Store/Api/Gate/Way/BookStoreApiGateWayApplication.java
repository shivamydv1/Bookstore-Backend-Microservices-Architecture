package com.api_gateway.Book.Store.Api.Gate.Way;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class BookStoreApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApiGateWayApplication.class, args);
	}

}
