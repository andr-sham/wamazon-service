package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.repository.IBaseRepository;
import com.wamazon.wamazonservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

//        Page<Product> all = pagingAndSortingRepository.findAll(pageable);

        return null;
    }

    public String concat(String a, String b) {
        return a + b;
    }

}
