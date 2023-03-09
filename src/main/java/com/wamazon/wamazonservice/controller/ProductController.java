package com.wamazon.wamazonservice.controller;

import com.wamazon.wamazonservice.dto.ProductDto;
import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.mapper.EntityMapper;
import com.wamazon.wamazonservice.mapper.ProductMapper;
import com.wamazon.wamazonservice.service.ICrudService;
import com.wamazon.wamazonservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController extends CrudController<Product, ProductDto> {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/search/findByName")
    public List<ProductDto> findByName(@RequestParam String name) {
        return productService.findByName(name).stream().map(productMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ICrudService<Product> getService() {
        return productService;
    }

    @Override
    public EntityMapper<Product, ProductDto> getMapper() {
        return productMapper;
    }
}
