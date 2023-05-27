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

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

@Tag(name = "Product")
@RestController
public class GetPvpController {

    @Autowired
    ProductService productService;

    @GetMapping("products")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @ApiResponse(responseCode = "400", description = "Id's cannot be negative")
    public ResponseEntity<ProductDto> response(
        @Parameter(description = "Date in yyyy-MM-dd-HH-mm-ss format", required = true, example = "2020-06-15-00.00.00") @RequestParam String date,
        @Parameter(description = "ID of product", required = true, example = "35455") @RequestParam Integer productId,
        @Parameter(description = "ID of brand", required = true, example = "1") @RequestParam Integer brandId, HttpServletResponse response) throws ProductNotFoundException, WrongDateFormatException, InvalidParameterException {
        response.addHeader("content-type", "application/json");

        if(productId < 0 || brandId < 0) {
            throw new InvalidParameterException("Id's cannot be negative");
        }
        var product = productService.getProduct(productId, brandId, date);
        return ResponseEntity.ok(ProductMapper.MAPPER.toDto(product));

    }

}
