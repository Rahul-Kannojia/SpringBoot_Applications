package com.app.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info =@Info(title ="Product API",description ="These APIs for Product",version = "1.0"))
public class ProductRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRestApiApplication.class, args);
	}

}
