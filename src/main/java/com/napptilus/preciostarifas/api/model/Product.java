package com.napptilus.preciostarifas.api.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Product {

    @Column(name = "BRAND_ID")
    Long brandId;

    @Temporal(TemporalType.TIME)
    @Column(name = "START_DATE")
    Date startDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "END_DATE")
    Date endDate;

    @Id
    @Column(name = "PRODUCT_ID")
    Long productId;

    @Column(name = "PRICE_LIST")
    Long priceListId;

    @Column(name = "PRICE")
    Double price;
    
    @Column(name = "CURR")
    String currency;

    @Column(name = "PRIORITY")
    Integer priority;

    public Product(int productId, int brandId, int priceListId, String startDate, String endDate, double price) {
    }
    
}