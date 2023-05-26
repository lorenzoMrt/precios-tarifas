package com.napptilus.preciostarifas.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napptilus.preciostarifas.DateUtils;
import com.napptilus.preciostarifas.api.exception.ProductNotFoundException;
import com.napptilus.preciostarifas.api.exception.WrongDateFormatException;
import com.napptilus.preciostarifas.api.model.Product;
import com.napptilus.preciostarifas.api.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(Integer productId, Integer brandId, String date)
            throws ProductNotFoundException, WrongDateFormatException {

        List<Product> productList = productRepository.findByProductIdAndBrandId(productId, brandId);
        if(productList == null) {
            throw new ProductNotFoundException("Product not found");
        }

        var product = returnProductByDateAndPriority(productList,
                DateUtils.createDateFor(date));

        return product;
    }

    /**
     * Returns a {@link Product} based on the given date and priority from a list of
     * products.
     * 
     * @param products The list of products to search from.
     * @param date     The date used to filter the products.
     * @return Product The product with the highest priority that matches the given
     *         date.
     * @throws ProductNotFoundException If no product is found for the given date.
     */
    private Product returnProductByDateAndPriority(List<Product> products, LocalDateTime date) throws ProductNotFoundException {

        var productResult = products.stream()
                .filter(product -> date.isBefore(product.getEndDate()) && date.isAfter(product.getStartDate()))
                .sorted((d1, d2) -> d2.getPriority().compareTo(d1.getPriority()))
                .findFirst();
        return productResult.orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

}