package com.napptilus.preciostarifas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.napptilus.preciostarifas.api.dto.ProductDto;
import com.napptilus.preciostarifas.api.exception.ProductNotFoundException;
import com.napptilus.preciostarifas.api.exception.WrongDateFormatException;
import com.napptilus.preciostarifas.api.service.ProductService;
import com.napptilus.preciostarifas.mapper.ProductMapper;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GetPvpController {

    @Autowired
    ProductService productService;

    @GetMapping("/product-pvp")
    public ResponseEntity<ProductDto> response(@RequestParam String date, @RequestParam Integer productId,
            @RequestParam Integer brandId, HttpServletResponse response) throws ProductNotFoundException, WrongDateFormatException {
        response.addHeader("content-type", "application/json");

        var product = productService.getProduct(productId, brandId, date);
        return ResponseEntity.ok(ProductMapper.MAPPER.toDto(product));

    }

}
