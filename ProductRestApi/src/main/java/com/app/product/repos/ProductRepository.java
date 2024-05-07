package com.app.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
