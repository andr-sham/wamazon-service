package com.wamazon.wamazonservice.controller;

import com.wamazon.wamazonservice.dto.AuthRequest;
import com.wamazon.wamazonservice.dto.UserDetails;
import com.wamazon.wamazonservice.service.UserDetailsContextService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Auth2Controller {

    private final UserDetailsContextService userDetailsContextService;

    @PostMapping("login2")
    public void login(@RequestBody AuthRequest authRequest) {
        UserDetails userDetails = new UserDetails();
        userDetails.setLogin(authRequest.getLogin());

        userDetailsContextService.setUserDetails(userDetails);
    }


}
