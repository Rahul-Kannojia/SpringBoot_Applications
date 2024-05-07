package com.app.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import com.app.product.entities.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;

@SpringBootTest
class ProductRestApiApplicationTests {

	@Value("${ProductRestApi.services.url}")
	private String baseURL;
	
	@Test
	void testGetProduct() {
		System.out.println("baseURL:"+ baseURL);
		RestTemplate rt = new RestTemplate(); 
		Product product = rt.getForObject(baseURL+"/1",Product.class);
		assertNotNull(product);
		assertEquals("Samsung Mobiles", product.getPname());
	}

	
	@Test
	void testcreateProduct() {
		RestTemplate rt = new RestTemplate(); 
		Product product = new Product();
		product.setPname("Smart Watches");
		product.setDescription("Good Watch");
		product.setPrice(10000);
		Product newProduct = rt.postForObject(baseURL,  product, Product.class);
		Assertions.assertNotNull(newProduct);
		Assertions.assertNotNull(newProduct.getPid());
		Assertions.assertEquals("Smart Watches",newProduct.getPname());
	}
	
	@Test
	void testupdateProduct() {
		RestTemplate rt = new RestTemplate(); 
		Product product = rt.getForObject(baseURL+"/1",Product.class);
		product.setPrice(1500);
		 rt.put("http://localhost:8081/productapp/products",  product);
		//Assertions.assertNotNull(updatedProduct);
		//Assertions.assertEquals(1400.0,updatedProduct.getPrice());
	}
}
