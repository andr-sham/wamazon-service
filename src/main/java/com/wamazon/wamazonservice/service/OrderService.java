package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.Order;
import com.wamazon.wamazonservice.repository.ICrudRepository;

public class OrderService extends CrudService<Order> {

    private ICrudRepository crudRepository;

    public OrderService(ICrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public ICrudRepository<Order> getRepository() {
        return crudRepository;
    }

    @Override
    protected void validate(Order order) {

    }
}
