package com.wamazon.wamazonservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
public abstract class IdentifiableEntity {

    /**
     * Уникальный идентификатор из БД
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
