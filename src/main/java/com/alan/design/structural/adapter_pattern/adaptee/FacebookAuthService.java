package com.alan.design.structural.adapter_pattern.adaptee;

import org.springframework.stereotype.Service;

@Service
public class FacebookAuthService {

    public String checkToken(String token) {
        return "FacebookInfo"; // skip detail
    }

    public void logout(String token) {
        // skip detail
    }
}
