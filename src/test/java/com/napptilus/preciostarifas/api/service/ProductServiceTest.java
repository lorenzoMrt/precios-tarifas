package com.napptilus.preciostarifas.api.service;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.napptilus.preciostarifas.api.model.Product;

@SpringBootTest
public class ProductServiceTest {
    
    @Test
    public void should_return_product() {

        Integer productId = 35455;
        String date = "2020-06-14-10.00.00";
        Integer brandId = 1;
        
        var productService = new ProductService();

        Product expectedProduct = new Product(35455, 1, 1, "2020-06-14-00.00.00", "2020-12-31-23.59.59", 35.50);

        Product actualProduct = productService.getProduct(productId, brandId, date);
        assertSame(expectedProduct, actualProduct);
    }
}
