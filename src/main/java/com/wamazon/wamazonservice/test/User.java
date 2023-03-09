package com.wamazon.wamazonservice.test;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс для хранения личных данных пользователя
 */
@Getter
@Setter
public class User {

    /**
     * Уникальный идентификатор из БД
     */
    private Long id;

    /**
     * Имя
     */
    private String firstName;

    /**
     * Фамилия
     */
    private String secondName;

    /**
     * Отчество
     */
    private String lastName;

    /**
     * Номер телефона
     */
    private String phone;

    /**
     * Дата рождения
     */
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

