package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends IBaseRepository<Product> {

    List<Product> findByNameIgnoreCase(String name);

    List<Product> findByDescription(String description);
}
