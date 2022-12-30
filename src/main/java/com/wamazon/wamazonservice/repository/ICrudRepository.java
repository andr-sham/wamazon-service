package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.dto.LongIdDto;

public interface ICrudRepository<T extends LongIdDto> {

    T save(T dtoToSave);

    T findOne(Long id);

    T update(T dtoToUpdate);

    void delete(Long id);
}
