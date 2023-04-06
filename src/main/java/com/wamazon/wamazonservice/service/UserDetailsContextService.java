package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.UserDetails;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDetailsContextService implements IUserDetailsContextService {

    public UserDetailsContextService() {
        UserDetails ud = new UserDetails();
        ud.setId(1L);

        this.userDetails = ud;
    }

    private UserDetails userDetails;

    @Override
    public UserDetails getUserDetails() {
        return this.userDetails;
    }

    @Override
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
