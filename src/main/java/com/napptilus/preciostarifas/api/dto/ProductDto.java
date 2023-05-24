package com.napptilus.preciostarifas.api.dto;


public record ProductDto(Integer productId, Integer brandId, Integer priceList, String startDate, String endDate, Double price) {
    
}
