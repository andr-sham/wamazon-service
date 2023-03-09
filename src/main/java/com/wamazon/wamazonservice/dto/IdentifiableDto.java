package com.wamazon.wamazonservice.dto;

import java.util.Objects;

public abstract class IdentifiableDto {

    /**
     * Уникальный идентификатор из БД
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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
        IdentifiableDto identifiableDto = (IdentifiableDto) o;
        return id == identifiableDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
