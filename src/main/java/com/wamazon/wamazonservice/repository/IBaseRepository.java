package com.wamazon.wamazonservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface IBaseRepository<T> extends CrudRepository<T, Long>, PagingAndSortingRepository<T, Long> {

}
