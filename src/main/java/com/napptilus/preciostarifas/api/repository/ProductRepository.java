package com.napptilus.preciostarifas.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napptilus.preciostarifas.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductIdAndBrandId(Integer productId, Integer brandId);
}
