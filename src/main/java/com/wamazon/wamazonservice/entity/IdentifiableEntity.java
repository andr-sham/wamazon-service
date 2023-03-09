package com.wamazon.wamazonservice.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

@MappedSuperclass
public abstract class IdentifiableEntity {

    /**
     * Уникальный идентификатор из БД
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdentifiableEntity identifiableDto = (IdentifiableEntity) o;
        return id == identifiableDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
