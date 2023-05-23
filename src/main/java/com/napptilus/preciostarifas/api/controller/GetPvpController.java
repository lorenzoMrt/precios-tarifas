package com.napptilus.preciostarifas.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GetPvpController {
    
    @GetMapping("/product-pvp")
    public ResponseEntity<String> response(@RequestParam String date, @RequestParam Integer productId, @RequestParam Integer brandId, HttpServletResponse response) {
        response.addHeader("content-type", "application/json");

        return ResponseEntity.ok(new JSONObject()
        .put("product-id", 35455)
        .put("brand-id", 1)
        .put("price-list", 1)
        .put("start-date", "2020-06-14-00.00.00")
        .put("end-date", "2020-12-31-23.59.59")
        .put("price", 35.50).toString());
    }
}
