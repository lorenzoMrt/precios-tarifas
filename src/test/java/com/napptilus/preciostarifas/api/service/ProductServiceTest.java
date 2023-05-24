package com.napptilus.preciostarifas.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {
    
    @Test
    public void should_return_product() {

        Integer productId;
        String date;
        Integer brandId;

        Product expectedProduct;
        Product actualProduct = productRepository.getProductBy(productId, date, brandId);
        assertEquals(expectedProduct, actualProduct);
    }
}
