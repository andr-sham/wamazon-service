package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.UserDetails;

public interface IUserDetailsContextService {
    UserDetails getUserDetails();

    void setUserDetails(UserDetails userDetails);
}
