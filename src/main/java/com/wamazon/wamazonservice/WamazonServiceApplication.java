package com.wamazon.wamazonservice;

import com.wamazon.wamazonservice.dto.Product;
import com.wamazon.wamazonservice.repository.ProductRepository;
import com.wamazon.wamazonservice.repository.SellerRepository;
import com.wamazon.wamazonservice.service.IProductService;
import com.wamazon.wamazonservice.service.ProductService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class WamazonServiceApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WamazonServiceApplication.class, args);
	}
}
