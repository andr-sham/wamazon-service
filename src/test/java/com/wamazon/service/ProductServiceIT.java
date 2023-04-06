package com.wamazon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wamazon.BaseServiceConfiguration;
import com.wamazon.wamazonservice.dto.UserDetails;
import com.wamazon.wamazonservice.entity.Cart;
import com.wamazon.wamazonservice.entity.Order;
import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.exception.GeneralException;
import com.wamazon.wamazonservice.service.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
public class ProductServiceIT extends BaseServiceConfiguration {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICartService cartService;

    @Autowired
    private IOrderService orderService;

    @MockBean
    private DollarConverterService dollarConverterService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IUserDetailsContextService userDetailsContextService;

    @Test
    public void productSave_Ok_Test() {
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
    public void productSave_EmptyName_Error_Test() {
        Product product = new Product();
        product.setPrice(new BigDecimal("10.00"));

        assertThrows(DataIntegrityViolationException.class, () -> productService.save(product));
    }

    @Test
    public void productFindByNameTest() {
        saveProductWithName("Велосипед");
        saveProductWithName("ВелосипеД");
        saveProductWithName("ВелосипеД2");
        saveProductWithName("велосипед");

        List<Product> products = productService.findByName("ВЕЛОСИПЕД");

        assertNotNull(products);
        assertEquals(3L, products.size());
    }

    @Test
    @Disabled
    public void productSaveMockTest() {
        when(dollarConverterService.getRublesByDollar()).thenReturn(33);
    }

    @Test
    public void productSaveMvcTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/1")).andExpect(status().is4xxClientError());

        Product product = saveProduct();

        mockMvc.perform(MockMvcRequestBuilders.get("/product/{id}", product.getId()))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void orderCreate_Success_Test() {
        Product product = saveProduct();

        Cart userCart = cartService.getUserCart();

        assertNotNull(userCart);
        assertTrue(userCart.getProducts().isEmpty());

        cartService.addProductToCart(product.getId());

        userCart = cartService.getUserCart();

        UserDetails userDetails = userDetailsContextService.getUserDetails();

        assertNotNull(userCart);
        assertEquals(1, userCart.getProducts().size());
        assertEquals(product.getId(), userCart.getProducts().get(0).getId());
        assertEquals(userDetails.getId(), userCart.getUserId());

        Order orderFromUserCart = orderService.createOrderFromUserCart();

        assertNotNull(orderFromUserCart);
        assertEquals(1, orderFromUserCart.getProducts().size());
        assertEquals(product.getId(), orderFromUserCart.getProducts().get(0).getId());
        assertTrue(userCart.getProducts().isEmpty());
    }

    @Test
    public void orderCreateErrorTest() {
        Cart userCart = cartService.getUserCart();

        assertNotNull(userCart);
        assertTrue(userCart.getProducts().isEmpty());

        assertThrows(GeneralException.class, () -> orderService.createOrderFromUserCart());
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
