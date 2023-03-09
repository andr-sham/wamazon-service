package com.wamazon.service;

import com.wamazon.wamazonservice.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductDtoServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void calculateCostTest() {
        int result = productService.calculateCost(1, 1);
        Assertions.assertThat(result).isEqualTo(2);
    }
}
