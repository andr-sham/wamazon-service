package com.wamazon.wamazonservice.test;

public abstract class UserService {

    abstract boolean isRequiredFieldsNotEmpty(User user);

    boolean isValidPassword(String password) {
        char[] passwordChars = password.toCharArray();

        boolean hasDigit = false;
        boolean hasLetter = false;

        for (char passwordChar : passwordChars) {
            boolean isDigit = Character.isDigit(passwordChar);

            hasDigit = hasDigit || isDigit;
            hasLetter = hasLetter || !isDigit;
        }

        return hasDigit && hasLetter;
    }

    boolean validate(User user) {
        String login = user.getLogin();
        String password = user.getPassword();

        if (isRequiredFieldsNotEmpty(user)) {
            System.out.println("Не все обязательные поля заполнены");
            return false;
        }

        if (login.length() <= 3 || password.length() <= 3) {
            System.out.println("Попытка регистрации с паролем или логином не более 3-х символов");
            return false;
        }

        if (!isValidPassword(password)) {
            System.out.println("Пароль является слишком простым");
            return false;
        }

        return true;
    }
}
