package com.wamazon.wamazonservice.test;

public class EmployeeService extends UserService {

    /**
     * Метод регистрации нового сотрудника
     */
    public boolean register(Employee employee) {
//        boolean isValid = validate(employee);
//
//        if (!isValid) {
//            System.out.println("Валидация прошла неуспешно");
//            return false;
//        }

        // продолжение метода регистрации

        return false;
    }

    @Override
    boolean isRequiredFieldsNotEmpty(User user) {
        return user.getLogin() != null && user.getPassword() != null &&
                user.getPersonalPhoneNumber() != null &&
                user.getName() != null;
    }

    @Override
    boolean isValidPassword(String password) {
        char[] passwordChars = password.toCharArray();

        boolean hasDigit = false;
        boolean hasLetter = false;
        boolean hasUnderscore = false;

        for (char passwordChar : passwordChars) {
            boolean isDigit = Character.isDigit(passwordChar);

            hasUnderscore = hasUnderscore || passwordChar == '_';
            hasDigit = hasDigit || isDigit;
            hasLetter = hasLetter || !isDigit;
        }

        return hasUnderscore && hasDigit && hasLetter;
    }
}
