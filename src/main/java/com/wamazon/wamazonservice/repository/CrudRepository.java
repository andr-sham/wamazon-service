package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.dto.LongIdDto;
import com.wamazon.wamazonservice.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class CrudRepository<T extends LongIdDto> implements ICrudRepository<T> {

    List<T> database = new ArrayList<>();

    private long idSequence;

    @Override
    public T save(T dtoToSave) {
        dtoToSave.setId(++idSequence);
        database.add(dtoToSave);
        return dtoToSave;
    }

    @Override
    public T findOne(Long id) {
        for (T dto : database) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }

        throw new NotFoundException();
    }

    @Override
    public T update(T dtoToUpdate) {
        database.remove(dtoToUpdate);
        database.add(dtoToUpdate);
        return dtoToUpdate;
    }

    @Override
    public void delete(Long id) {
        database.removeIf(next -> next.getId() == id);
    }
}
