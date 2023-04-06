package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends IBaseRepository<Product> {

    List<Product> findByNameIgnoreCase(String name);

    List<Product> findByDescription(String description);

    Page<Product> findByNameIgnoreCase(String name, Pageable pageable);
}
