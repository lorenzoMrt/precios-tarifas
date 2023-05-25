package com.napptilus.preciostarifas.api.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE")
    Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE")
    Date endDate;

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

    public Product(int brandId,Date startDate, Date endDate,Integer productId, int priceListId, double price, String currency, int priority) {
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