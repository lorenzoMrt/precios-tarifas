package com.napptilus.preciostarifas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.napptilus.preciostarifas.api.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GetPvpController {
    
    @Autowired
    ProductService productService;
    @GetMapping("/product-pvp")
    public ResponseEntity<String> response(@RequestParam String date, @RequestParam Integer productId, @RequestParam Integer brandId, HttpServletResponse response) {
        response.addHeader("content-type", "application/json");

        var jsonObject = productService.getPvpForProduct(productId, brandId, date);
        
        return ResponseEntity.ok(jsonObject);
    }
}
