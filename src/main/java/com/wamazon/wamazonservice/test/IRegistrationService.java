package com.wamazon.wamazonservice.test;

public interface IRegistrationService {

    /**
     * Метод регистрации нового пользователя
     */
    User register(User user);

    /**
     * Метод проверки наличия логина в системе
     */
    boolean checkLoginExistence(User id);

}
