package com.napptilus.preciostarifas;

import java.util.ArrayList;
import java.util.List;

import com.napptilus.preciostarifas.api.model.Product;

public class ProductMother {
    
    private static final String CURR = "EUR";

    public static List<Product> mockProductList() {
        var productList =  new ArrayList<Product>();
        var product1 = new Product(1L, DateUtils.createDateFor("2020-06-14-00.00.00"), DateUtils.createDateFor("2020-12-31-23.59.59"), 35455L, 1L, 35.50, CURR, 0);
        productList.add(product1);
        var product2 = new Product(1L, DateUtils.createDateFor("2020-06-14-15.00.00"), DateUtils.createDateFor("2020-06-14-18.30.00"), 35455L, 2L, 25.45, CURR, 1);
        productList.add(product2);
        
        var product3 = new Product(1L, DateUtils.createDateFor("2020-06-15-00.00.00"), DateUtils.createDateFor("2020-06-15-11.00.00"), 35455L, 3L, 30.50, CURR, 1);
        productList.add(product3);
        
        var product4 = new Product(1L, DateUtils.createDateFor("2020-06-16-00.00.00"), DateUtils.createDateFor("2020-12-31-23.59.59"), 35455L, 4L, 38.95, CURR, 1);
        productList.add(product4);
        
        return productList;
    }
}
