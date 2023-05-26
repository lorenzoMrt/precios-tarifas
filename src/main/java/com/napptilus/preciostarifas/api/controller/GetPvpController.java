package com.napptilus.preciostarifas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.napptilus.preciostarifas.api.dto.ProductDto;
import com.napptilus.preciostarifas.api.exception.ProductNotFoundException;
import com.napptilus.preciostarifas.api.service.ProductService;
import com.napptilus.preciostarifas.mapper.ProductMapper;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GetPvpController {
    
    @Autowired
    ProductService productService;
    @GetMapping("/product-pvp")
    public ResponseEntity<ProductDto> response(@RequestParam String date, @RequestParam Integer productId, @RequestParam Integer brandId, HttpServletResponse response) {
        response.addHeader("content-type", "application/json");

        try {
            var product = productService.getProduct(productId, brandId, date);
            return ResponseEntity.ok(ProductMapper.MAPPER.toDto(product));
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        
    }
}
