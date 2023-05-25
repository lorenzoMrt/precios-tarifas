package com.napptilus.preciostarifas.api.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    public Product(int productId, int brandId, int priceListId, String startDate, String endDate, double price, int priority) {
        this.productId = Long.valueOf(productId);
        this.priceListId = Long.valueOf(priceListId);
        this.brandId = Long.valueOf(brandId);
        this.price = price;
        try {
            this.startDate = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").parse(startDate);
            this.endDate = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").parse(endDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.priority = priority;
    }
    
}