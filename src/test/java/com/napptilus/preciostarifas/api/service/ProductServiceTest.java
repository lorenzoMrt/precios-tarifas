package com.napptilus.preciostarifas.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.napptilus.preciostarifas.api.model.Product;

@SpringBootTest
public class ProductServiceTest {
    
    @Test
    public void should_return_pvp_of_3550_at_1000() {

        Integer productId = 35455;
        String date = "2020-06-14-10.00.00";
        Integer brandId = 1;
        
        var productService = new ProductService();

        var expectedPrice = 35.50;
        
        Product actualProduct = productService.getProduct(productId, brandId, date);
        assertEquals(expectedPrice, actualProduct.getPrice());
    }

    @Test
    public void should_return_pvp_of_2545_at_1600() {

        Integer productId = 35455;
        String date = "2020-06-14-16.00.00";
        Integer brandId = 1;
        
        var productService = new ProductService();

        var expectedPrice = 25.45;
        Product actualProduct = productService.getProduct(productId, brandId, date);
        assertEquals(expectedPrice, actualProduct.getPrice());
    }

    @Test
    public void should_return_pvp_of_3550_at_2100() {

        Integer productId = 35455;
        String date = "2020-06-14-21.00.00";
        Integer brandId = 1;
        
        var productService = new ProductService();

        var expectedPrice = 35.50;
        Product actualProduct = productService.getProduct(productId, brandId, date);
        assertEquals(expectedPrice, actualProduct.getPrice());
    }

    @Test
    public void should_return_pvp_of_3050_at_day_15_1000() {
        Integer productId = 35455;
        String date = "2020-06-15-10.00.00";
        Integer brandId = 1;
        
        var productService = new ProductService();

        var expectedPrice = 30.50;
        Product actualProduct = productService.getProduct(productId, brandId, date);
        assertEquals(expectedPrice, actualProduct.getPrice());
    }
}
