package com.wamazon.stubs;

import com.wamazon.wamazonservice.dto.UserDetails;
import com.wamazon.wamazonservice.service.IUserDetailsContextService;

public class UserDetailsContextServiceStub implements IUserDetailsContextService {

    @Override
    public UserDetails getUserDetails() {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(66L);
        userDetails.setLogin("test-user");
        userDetails.setName("Тестовый Пользователь");
        return userDetails;
    }

    @Override
    public void setUserDetails(UserDetails userDetails) {

    }
}
