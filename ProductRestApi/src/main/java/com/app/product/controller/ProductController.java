package com.app.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.entities.Product;
import com.app.product.repos.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@Tag(name = "Product Rest Endpoints",description = "Product Controller")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/products")
	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	@Operation(description = "Return List Of Products",summary = "Return Products")
	public List<Product> getProdcuts(){
		LOGGER.info("Fetching List of Products available");
		return productRepo.findAll();
	}
	
	@GetMapping("/products/{id}")
	@Operation(description = "Take Id and return single Product",summary = "Return a Product")
	public @ApiResponse(description = "Product Object") Product findProduct(@Parameter(description = "Product Id")@PathVariable("id") int pid) {
		LOGGER.info("Fetching Single Product on the basis of Product Id");
		return productRepo.findById(pid).get();
	}
	
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepo.save(product);
	}
	
	@PutMapping("/products")
	public Product updateProduct(@Valid @RequestBody Product product) {
	   return productRepo.save(product);	
	}

	@DeleteMapping("/products/{id}")
	@CacheEvict("product-cache")
	public void deleteProduct(@PathVariable("id") int pid) {
		 productRepo.deleteById(pid);
	}
}
