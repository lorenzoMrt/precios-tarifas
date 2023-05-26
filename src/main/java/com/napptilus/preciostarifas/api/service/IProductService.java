package com.napptilus.preciostarifas.api.service;

import com.napptilus.preciostarifas.api.exception.ProductNotFoundException;
import com.napptilus.preciostarifas.api.model.Product;

public interface IProductService {
    Product getProduct(Integer productId, Integer brandId, String date) throws ProductNotFoundException;
}
