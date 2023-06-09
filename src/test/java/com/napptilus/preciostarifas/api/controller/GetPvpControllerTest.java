package com.napptilus.preciostarifas.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.napptilus.preciostarifas.ProductMother;
import com.napptilus.preciostarifas.api.ApiTestCase;
import com.napptilus.preciostarifas.api.exception.InvalidParameterException;
import com.napptilus.preciostarifas.api.exception.ProductNotFoundException;
import com.napptilus.preciostarifas.api.exception.WrongDateFormatException;
import com.napptilus.preciostarifas.api.repository.ProductRepository;

public class GetPvpControllerTest extends ApiTestCase {

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void should_return_pvp_at_1000() throws Exception {
        when(productRepository.findByProductIdAndBrandId(any(), any())).thenReturn(ProductMother.mockProductList());
        whenGetRequestSentTo("/products?date=2020-06-14-10.00.00&productId=35455&brandId=1");

        var jsonResponse = new JSONObject()
            .put("productId", 35455)
            .put("brandId", 1)
            .put("priceList", 1)
            .put("startDate", "2020-06-14-00.00.00")
            .put("endDate", "2020-12-31-23.59.59")
            .put("price", 35.50);

        assertSuccessJsonResponse(jsonResponse);
    }

    @Test
    public void should_return_404_product_not_found() throws Exception {
        when(productRepository.findByProductIdAndBrandId(any(), any())).thenReturn(null);

        assertExceptionIsThrown(ProductNotFoundException.class, "/products?date=0000-00-00-10.00.00&productId=35455&brandId=1");

    }

    @Test
    public void should_return_400_wrong_date_format() throws Exception {
        when(productRepository.findByProductIdAndBrandId(any(), any())).thenReturn(null);

        assertExceptionIsThrown(WrongDateFormatException.class, "/products?date=0000-00234-00_10.00.00&productId=35455&brandId=1");
    }

    @Test
    public void should_return_400_invalid_parameter_value() throws Exception {
        assertExceptionIsThrown(InvalidParameterException.class, "/products?date=2020-06-14-10.00.00&productId=-35455&brandId=-1");
        
    }
}
