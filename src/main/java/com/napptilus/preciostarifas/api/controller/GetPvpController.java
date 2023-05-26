package com.napptilus.preciostarifas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.napptilus.preciostarifas.api.dto.ProductDto;
import com.napptilus.preciostarifas.api.exception.InvalidParameterException;
import com.napptilus.preciostarifas.api.exception.ProductNotFoundException;
import com.napptilus.preciostarifas.api.exception.WrongDateFormatException;
import com.napptilus.preciostarifas.api.service.ProductService;
import com.napptilus.preciostarifas.mapper.ProductMapper;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GetPvpController {

    @Autowired
    ProductService productService;

    @GetMapping("products")
    public ResponseEntity<ProductDto> response(@RequestParam String date, @RequestParam Integer productId,
            @RequestParam Integer brandId, HttpServletResponse response) throws ProductNotFoundException, WrongDateFormatException, InvalidParameterException {
        response.addHeader("content-type", "application/json");

        if(productId < 0 || brandId < 0) {
            throw new InvalidParameterException("Id's cannot be negative");
        }
        var product = productService.getProduct(productId, brandId, date);
        return ResponseEntity.ok(ProductMapper.MAPPER.toDto(product));

    }

}
