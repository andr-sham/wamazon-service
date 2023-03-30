package com.wamazon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wamazon.BaseServiceConfiguration;
import com.wamazon.wamazonservice.entity.Order;
import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.service.IOrderService;
import com.wamazon.wamazonservice.service.IProductService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductServiceIT extends BaseServiceConfiguration {

    @Autowired
    private IProductService productService;

    @MockBean
    private IOrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void productSaveOkTest() {
        Product product = new Product();
        product.setName("Велик");
        product.setPrice(new BigDecimal("10.00"));

        Product savedProduct = productService.save(product);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());

        savedProduct = productService.get(savedProduct.getId());

        assertEquals("Велик", savedProduct.getName());
        assertEquals(new BigDecimal("10.00"), savedProduct.getPrice());
    }

    @Test
    public void productFindByNameTest() {
        saveProductWithName("Велосипед");
        saveProductWithName("ВелосипеД");
        saveProductWithName("велосипед");

        List<Product> products = productService.findByName("ВЕЛОСИПЕД");

        assertNotNull(products);
        assertEquals(3L, products.size());
    }

    @Test
    public void productSaveMockTest() {
        Order testOrder = new Order();
        testOrder.setId(33L);

        Mockito.when(orderService.get(1L)).thenReturn(testOrder);

        Order order = orderService.get(1L);
        assertEquals(33L, order.getId());
    }

    @Test
    public void productSaveMvcTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/1")).andExpect(status().is4xxClientError());

        Product product = saveProduct();

        mockMvc.perform(MockMvcRequestBuilders.get("/product/{id}", product.getId()))
                .andExpect(status().is2xxSuccessful());

    }

    private Product saveProduct() {
        return saveProductWithName(RandomStringUtils.randomAlphabetic(10));
    }

    private Product saveProductWithName(String name) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(new BigDecimal("10.00"));

        Product savedProduct = productService.save(product);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());

        return product;
    }
}
