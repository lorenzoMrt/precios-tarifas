package com.napptilus.preciostarifas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.napptilus.preciostarifas.api.model.Product;
import com.napptilus.preciostarifas.api.repository.ProductRepository;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private static final String CURR = "EUR";
    private final ProductRepository productRepository;
    @Autowired
    public DatabaseInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        populateDatabase();
    }

    private void populateDatabase() {
        var product1 = new Product(1L, DateUtils.createDateFor("2020-06-14-00.00.00"), DateUtils.createDateFor("2020-12-31-23.59.59"), 35455L, 1L, 35.50, CURR, 0);
        productRepository.save(product1);
        var product2 = new Product(1L, DateUtils.createDateFor("2020-06-14-15.00.00"), DateUtils.createDateFor("2020-06-14-18.30.00"), 35455L, 2L, 25.45, CURR, 1);
        productRepository.save(product2);
        var product3 = new Product(1L, DateUtils.createDateFor("2020-06-15-00.00.00"), DateUtils.createDateFor("2020-06-15-11.00.00"), 35455L, 3L, 30.50, CURR, 1);
        productRepository.save(product3);
        var product4 = new Product(1L, DateUtils.createDateFor("2020-06-16-00.00.00"), DateUtils.createDateFor("2020-12-31-23.59.59"), 35455L, 4L, 38.95, CURR, 1);
        productRepository.save(product4);
    }

    
    
}
