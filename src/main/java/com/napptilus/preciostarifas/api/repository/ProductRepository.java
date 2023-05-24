package com.napptilus.preciostarifas.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.napptilus.preciostarifas.api.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByProductIdAndBrandId(Integer productId, Integer brandId);
}
