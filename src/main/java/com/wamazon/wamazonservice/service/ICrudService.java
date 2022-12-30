package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.LongIdDto;

public interface ICrudService<T extends LongIdDto> {


    T save(T dtoToSave);

    T get(Long id);

    T update(T dtoToUpdate);

    void delete(Long id);
}
