package com.wamazon.wamazonservice.controller;

import com.wamazon.wamazonservice.dto.ProductDto;
import com.wamazon.wamazonservice.dto.ProductFilter;
import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.mapper.EntityMapper;
import com.wamazon.wamazonservice.mapper.ProductMapper;
import com.wamazon.wamazonservice.service.ICrudService;
import com.wamazon.wamazonservice.service.IProductService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController extends CrudController<Product, ProductDto> {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private String string;

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

    @PostMapping("generate")
    public void generate(@RequestBody ProductDto dtoToSave) {
        for (int i = 0; i < 100_000; i++) {
            Product productToSave = productMapper.mapToEntity(dtoToSave);
            productToSave.setName(RandomStringUtils.randomAlphabetic(33));
            productService.save(productToSave);
        }
    }

    @PostMapping("list")
    public Page<ProductDto> list(@RequestBody ProductFilter productFilter, Pageable pageable) {
        return getService().findPage(productFilter, pageable).map(getMapper()::mapToDto);
    }
}
