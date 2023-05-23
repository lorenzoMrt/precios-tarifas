package com.napptilus.preciostarifas.api.service;

public interface IProductService {
    String getPvpForProduct(Integer productId, Integer brandId, String date);
}
