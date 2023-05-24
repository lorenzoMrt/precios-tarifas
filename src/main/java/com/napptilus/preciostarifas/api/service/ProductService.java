package com.napptilus.preciostarifas.api.service;

import org.springframework.stereotype.Service;

import com.napptilus.preciostarifas.api.model.Product;

@Service
public class ProductService implements IProductService {

    @Override
    public Product getProduct(Integer productId, Integer brandId, String date) {

        if(date.equals("2020-06-14-16.00.00")) {
            return new Product(35455, 1, 1, "2020-06-14-00.00.00", "2020-12-31-23.59.59", 25.45);
        }
        if(date.equals("2020-06-15-10.00.00")) {
            return new Product(35455, 1, 1, "2020-06-14-00.00.00", "2020-12-31-23.59.59", 30.50);
        }
        if(date.equals("2020-06-16-10.00.00")) {
            return new Product(35455, 1, 1, "2020-06-14-00.00.00", "2020-12-31-23.59.59", 38.95);
        }
        
        return new Product(35455, 1, 1, "2020-06-14-00.00.00", "2020-12-31-23.59.59", 35.50);
    }
    
}
