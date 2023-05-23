package com.napptilus.preciostarifas.api.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Override
    public String getPvpForProduct(Integer productId, Integer brandId, String date) {
        
        return new JSONObject()
        .put("product-id", 35455)
        .put("brand-id", 1)
        .put("price-list", 1)
        .put("start-date", "2020-06-14-00.00.00")
        .put("end-date", "2020-12-31-23.59.59")
        .put("price", 35.50).toString();
    }
    
}
