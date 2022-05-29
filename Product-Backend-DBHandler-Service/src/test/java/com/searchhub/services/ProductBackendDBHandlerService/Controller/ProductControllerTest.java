package com.searchhub.services.ProductBackendDBHandlerService.Controller;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import com.searchhub.services.ProductBackendDBHandlerService.Entity.Products;
import com.searchhub.services.ProductBackendDBHandlerService.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository productRepository;

    @Test
    void testGetProduct() {
        Products productsTest = new Products();
        BigInteger id1 = BigInteger.valueOf(99);
        productsTest.setId(id1);
        productsTest.setProductname("Test Product");
        productsTest.setPicture("Test Picture");

        when(productController.getProduct(productsTest.getId())).thenReturn(productsTest);

        //When
        Products result = productController.getProduct(productsTest.getId());

        //Then
        assertThat(result.equals(productsTest));
    }

    @Test
    void testGetProducts() {
        Products products1 = new Products();
        BigInteger id1 = BigInteger.valueOf(435);
        products1.setId(id1);
        products1.setProductname("Products1");
        products1.setPicture("Products1 - Picture");

        Products products2 = new Products();
        BigInteger id2 = BigInteger.valueOf(542);
        products2.setProductname("Products2");
        products2.setPicture("Products2 - Picture");

        Products products3 = new Products();
        BigInteger id3 = BigInteger.valueOf(333);
        products3.setId(id3);
        products3.setProductname("Products3");
        products3.setPicture("Products3 - Picture");

        List<Products> productsList = new ArrayList<>();
        productsList.add(products1);
        productsList.add(products2);
        productsList.add(products3);

        when(productController.getProducts()).thenReturn(productsList);

        //When
        List<Products> result = productController.getProducts();

        //Then
        assertThat(result.size() == 3);
        assertThat(result.get(0).getProductname() == products1.getProductname());
        assertThat(result.get(1).getProductname() == products2.getProductname());
    }
}