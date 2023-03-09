package com.wamazon.wamazonservice.dto;

import com.wamazon.wamazonservice.dto.valiation.Create;
import com.wamazon.wamazonservice.dto.valiation.Update;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.util.Objects;

public abstract class IdentifiableDto {

    /**
     * Уникальный идентификатор из БД
     */
    @NotNull(message = "Не указан id для обновляемой сущности", groups = {Update.class})
    @Null(message = "Указан id для сохраняемой сущности", groups = {Create.class})
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
