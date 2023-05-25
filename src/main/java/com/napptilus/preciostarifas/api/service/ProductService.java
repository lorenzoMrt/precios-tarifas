package com.napptilus.preciostarifas.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napptilus.preciostarifas.api.model.Product;
import com.napptilus.preciostarifas.api.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(Integer productId, Integer brandId, String date) {

        List<Product> productList = productRepository.findByProductIdAndBrandId(productId, brandId);

        Product product = null;
        try {
            product = returnProductByDateAndPriority(productList,
                    new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").parse(date));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return product;
    }

    private Product returnProductByDateAndPriority(List<Product> products, Date date) {
        
        return products.stream()
            .filter(product -> date.before(product.getEndDate()) && date.after(product.getStartDate()))
            .sorted((d1, d2) -> d2.getPriority().compareTo(d1.getPriority()))
            .collect(Collectors.toList())
            .get(0);
    }

}