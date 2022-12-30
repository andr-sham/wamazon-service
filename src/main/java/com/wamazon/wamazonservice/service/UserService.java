package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.User;

public abstract class UserService<T extends User> {
    /*
    public abstract ICrudRepository<T> getRepository();

    @Override
    public boolean register(String login, String password) {

        // проверить, что логин и пароль не пустые
        if (login.isEmpty() || password.isEmpty()) {
            System.out.println("Попытка регистрации с пустым паролем или логином");
            return false;
        }

        if (login.length() <= 3 || password.length() <= 3) {
            System.out.println("Попытка регистрации с паролем или логином не более 3-х символов");
            return false;
        }

        isValidPassword(password);

        if (isLoginAlreadyUsed(login)) {
            System.out.println("Попытка регистрации с логином, который уже используется другим пользователем");
            return false;
        }

        getRepository().save();
        System.out.println("Пользователь с логином " + login + " зарегистрирован");

        return true;
    }

    private boolean isLoginAlreadyUsed(String searchLogin) {
        User userByLogin = getRepository().getUserByLogin(searchLogin);
        return userByLogin != null;
    }

    private void isValidPassword(String password) {
        char[] passwordChars = password.toCharArray();

        boolean hasDigit = false;
        boolean hasLetter = false;

        for (char passwordChar : passwordChars) {
            boolean isDigit = Character.isDigit(passwordChar);

            hasDigit = hasDigit || isDigit;
            hasLetter = hasLetter || !isDigit;
        }

        if (!(hasDigit && hasLetter)) {
            throw new RuntimeException("Пароль не корректный");
        }
    }

    @Override
    public T login(String login, String password) {
        T userByLogin = getRepository().getUserByLogin(login);

        if (userByLogin == null) {
            System.out.println("Авторизация не пройдена: Пользователь с логином " + login + " в системе не найден");
            return null;
        }

        boolean passwordCheckPassed = userByLogin.getPassword().equals(password);

        if (!passwordCheckPassed) {
            System.out.println("Авторизация не пройдена: Пароль для пользователя " + login + " указан не корректно");
            return null;
        }

        System.out.println("Авторизация пройдена: Пользователь " + login + " успешно авторизован");
        return userByLogin;
    }

    @Override
    public T updateUserProfile(T user) {
        return getRepository().updateUser(user);
    }*/
}
