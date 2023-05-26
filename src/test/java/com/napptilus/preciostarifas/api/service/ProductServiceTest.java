package com.napptilus.preciostarifas.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.napptilus.preciostarifas.ProductMother;
import com.napptilus.preciostarifas.api.exception.WrongDateFormatException;
import com.napptilus.preciostarifas.api.exception.ProductNotFoundException;
import com.napptilus.preciostarifas.api.model.Product;
import com.napptilus.preciostarifas.api.repository.ProductRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductServiceTest {
    
    
    @Mock
    private ProductRepository productRepository;
    
    @InjectMocks
    private ProductService productService;
    
    @BeforeAll
    public  void openMocks() {
        MockitoAnnotations.openMocks(ProductServiceTest.class);
    }

    
    @Test
    public void should_return_pvp_of_3550_at_day_14_1000() throws WrongDateFormatException {

        Integer productId = 35455;
        String date = "2020-06-14-10.00.00";
        Integer brandId = 1;
        
        

        var expectedPrice = 35.50;

        when(productRepository.findByProductIdAndBrandId(productId, brandId)).thenReturn(ProductMother.mockProductList());
        
        Product actualProduct;
        try {
            actualProduct = productService.getProduct(productId, brandId, date);
            assertEquals(expectedPrice, actualProduct.getPrice());
        } catch (ProductNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WrongDateFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void should_return_pvp_of_2545_at_day_14_1600() throws WrongDateFormatException {

        Integer productId = 35455;
        String date = "2020-06-14-16.00.00";
        Integer brandId = 1;
        
        

        var expectedPrice = 25.45;
        when(productRepository.findByProductIdAndBrandId(productId, brandId)).thenReturn(ProductMother.mockProductList());
        Product actualProduct;
        try {
            actualProduct = productService.getProduct(productId, brandId, date);
            assertEquals(expectedPrice, actualProduct.getPrice());
        } catch (ProductNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WrongDateFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void should_return_pvp_of_3550_at_day_14_2100() throws WrongDateFormatException {

        Integer productId = 35455;
        String date = "2020-06-14-21.00.00";
        Integer brandId = 1;
        
        

        var expectedPrice = 35.50;
        when(productRepository.findByProductIdAndBrandId(productId, brandId)).thenReturn(ProductMother.mockProductList());
        Product actualProduct;
        try {
            actualProduct = productService.getProduct(productId, brandId, date);
            assertEquals(expectedPrice, actualProduct.getPrice());
        } catch (ProductNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WrongDateFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void should_return_pvp_of_3050_at_day_15_1000() throws WrongDateFormatException {
        Integer productId = 35455;
        String date = "2020-06-15-10.00.00";
        Integer brandId = 1;
        
        

        var expectedPrice = 30.50;
        when(productRepository.findByProductIdAndBrandId(productId, brandId)).thenReturn(ProductMother.mockProductList());
        Product actualProduct;
        try {
            actualProduct = productService.getProduct(productId, brandId, date);
            assertEquals(expectedPrice, actualProduct.getPrice());
        } catch (ProductNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WrongDateFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void should_return_pvp_of_3895_at_day_16_2100() throws WrongDateFormatException {
        Integer productId = 35455;
        String date = "2020-06-16-10.00.00";
        Integer brandId = 1;
        
        

        var expectedPrice = 38.95;
        when(productRepository.findByProductIdAndBrandId(productId, brandId)).thenReturn(ProductMother.mockProductList());
        Product actualProduct;
        try {
            actualProduct = productService.getProduct(productId, brandId, date);
            assertEquals(expectedPrice, actualProduct.getPrice());
        } catch (ProductNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WrongDateFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void should_throw_product_not_found_exception() {
        Integer productId = 35455;
        String date = "0000-00-00-00.00.00";
        Integer brandId = 1;
        when(productRepository.findByProductIdAndBrandId(productId, brandId)).thenReturn(null);
        ProductNotFoundException thrown = assertThrows(ProductNotFoundException.class, () -> productService.getProduct(productId, brandId, date));

        assertEquals("Product not found", thrown.getMessage());
        
    }

    @Test
    public void should_throw_wrong_date_format_exception() {
        Integer productId = 35455;
        String date = "0000-0023-00_00.00.00";
        Integer brandId = 1;
        when(productRepository.findByProductIdAndBrandId(productId, brandId)).thenReturn(null);
        WrongDateFormatException thrown = assertThrows(WrongDateFormatException.class, () -> productService.getProduct(productId, brandId, date));

        assertEquals("Wrong date format. Example: 1960-12-11-10.00.00", thrown.getMessage());
    }
}
