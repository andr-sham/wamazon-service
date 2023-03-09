package com.wamazon.wamazonservice.test;

public class BuyerService extends UserService {

    /**
     * Метод регистрации нового покупателя
     */
    public boolean register(Buyer buyer) {
//        boolean isValid = validate(buyer);
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
        return false;
    }
}
