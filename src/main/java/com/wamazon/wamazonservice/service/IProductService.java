package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.ProductFilter;
import com.wamazon.wamazonservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends ICrudService<Product> {
    List<Product> findByName(String name);

    Page<Product> findPage(ProductFilter productFilter, Pageable pageable);
}
