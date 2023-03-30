package com.wamazon.service;

import com.wamazon.wamazonservice.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService productService = new ProductService();

    @Test
    public void concatTest() {
        String concat = productService.concat("Hel", "lo");
        Assertions.assertEquals("Hello", concat);
    }
}
