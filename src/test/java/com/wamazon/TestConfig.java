package com.wamazon;

import com.wamazon.stubs.UserDetailsContextServiceStub;
import com.wamazon.wamazonservice.service.IUserDetailsContextService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public IUserDetailsContextService userDetailsContextServiceStub() {
        return new UserDetailsContextServiceStub();
    }
}
