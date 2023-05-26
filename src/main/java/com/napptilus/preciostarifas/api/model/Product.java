package com.napptilus.preciostarifas.api.model;




import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "BRAND_ID")
    Integer brandId;

    @Column(name = "START_DATE", columnDefinition = "TIMESTAMP")
    LocalDateTime startDate;

    @Column(name = "END_DATE", columnDefinition = "TIMESTAMP")
    LocalDateTime endDate;

    @Column(name = "PRODUCT_ID")
    Integer productId;

    @Column(name = "PRICE_LIST")
    Integer priceListId;

    @Column(name = "PRICE")
    Double price;
    
    @Column(name = "CURR")
    String currency;

    @Column(name = "PRIORITY")
    Integer priority;

    public Product(int brandId,LocalDateTime startDate, LocalDateTime endDate,Integer productId, int priceListId, double price, String currency, int priority) {
        this.productId = productId;
        this.priceListId = priceListId;
        this.brandId = brandId;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
        this.priority = priority;
    }

    
}