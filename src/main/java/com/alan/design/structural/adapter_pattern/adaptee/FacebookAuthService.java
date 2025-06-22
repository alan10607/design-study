package com.alan.design.structural.adapter_pattern.adaptee;

import org.springframework.stereotype.Service;

@Service
public class FacebookAuthService {

    public String checkToken(String token) {
        // skip detail
        return "Facebook, checkToken with " + token;
    }

    public String logout(String token) {
        // skip detail
        return "Facebook, logout with " + token;
    }
}
