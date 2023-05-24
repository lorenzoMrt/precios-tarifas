package com.napptilus.preciostarifas.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.napptilus.preciostarifas.api.model.Product;

@Service
public class ProductService implements IProductService {

    @Override
    public Product getProduct(Integer productId, Integer brandId, String date) {

        List<Product> productList = new ArrayList<>();
        var p1 = new Product(35455, 1, 1, "2020-06-14-00.00.00", "2020-12-31-23.59.59", 35.50, 0);
        var p2 = new Product(35455, 1, 2, "2020-06-14-15.00.00", "2020-06-14-18.30.00", 25.45, 1);
        var p3 = new Product(35455, 1, 3, "2020-06-15-00.00.00", "2020-06-15-11.00.00", 30.50, 1);
        var p4 = new Product(35455, 1, 4, "2020-06-16-00.00.00", "2020-12-31-23.59.59", 38.95, 1);
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);

        Product product = null;
        try {
            product = returnProductByDateAndPriority(productList,
                    new SimpleDateFormat("yyyy-mm-dd-HH.mm.ss").parse(date));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return product;
    }

    private Product returnProductByDateAndPriority(List<Product> products, Date date) {
        List<Product> aux = new ArrayList<>();
        for (Product product : products) {
            if(date.before(product.getEndDate()) && date.after(product.getStartDate())) {
                aux.add(product);
            }
        }
        Collections.sort(aux, (d1, d2) -> d2.getPriority().compareTo(d1.getPriority()));
        return aux.get(0);
    }

}
