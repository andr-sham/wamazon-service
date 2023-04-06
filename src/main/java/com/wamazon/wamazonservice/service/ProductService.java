package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.ProductFilter;
import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.repository.IBaseRepository;
import com.wamazon.wamazonservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService extends CrudService<Product> implements IProductService {

    @Autowired
    private IProductRepository productRepository;


    @Override
    public IBaseRepository<Product> getRepository() {
        return productRepository;
    }

    //    @Cacheable("findProductByName")
    public List<Product> findByName(String name) {
        return productRepository.findByNameIgnoreCase(name);
    }

    public String concat(String a, String b) {
        if (a == null || b == null) {
            return "";
        }

        return a + b;
    }

    @Override
    public Page<Product> findPage(ProductFilter productFilter, Pageable pageable) {
        String name = productFilter.getName();
        return productRepository.findByNameIgnoreCase(name, pageable);
    }
}
