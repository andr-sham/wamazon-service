package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.Order;

public interface IOrderService {

    Order get(Long id);
}
