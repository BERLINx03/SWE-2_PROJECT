package com.project.ecommerce.repository;

import com.project.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findALlByNameContaining(String title);
}
