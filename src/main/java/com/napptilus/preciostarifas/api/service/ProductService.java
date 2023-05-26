package com.napptilus.preciostarifas.api.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napptilus.preciostarifas.DateUtils;
import com.napptilus.preciostarifas.api.exception.ProductNotFoundException;
import com.napptilus.preciostarifas.api.model.Product;
import com.napptilus.preciostarifas.api.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(Integer productId, Integer brandId, String date) throws ProductNotFoundException {

        List<Product> productList = productRepository.findByProductIdAndBrandId(productId, brandId);

        Product product = null;

        product = returnProductByDateAndPriority(productList,
                DateUtils.createDateFor(date));

        return product;
    }

    private Product returnProductByDateAndPriority(List<Product> products, Date date) throws ProductNotFoundException {
        Product productResult = null;
        try {
            
            productResult = products.stream()
                    .filter(product -> date.before(product.getEndDate()) && date.after(product.getStartDate()))
                    .sorted((d1, d2) -> d2.getPriority().compareTo(d1.getPriority()))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (NullPointerException e) {
           throw new ProductNotFoundException("Product not found");
        }
        return productResult;
    }

}