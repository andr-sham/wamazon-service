package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.dto.IdentifiableDto;

public interface ICrudRepository<T extends IdentifiableDto> {

    T save(T dtoToSave);

    T findOne(Long id);

    T update(T dtoToUpdate);

    void delete(Long id);
}
