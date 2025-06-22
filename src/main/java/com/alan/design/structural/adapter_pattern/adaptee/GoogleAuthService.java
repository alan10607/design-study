package com.alan.design.structural.adapter_pattern.adaptee;

import org.springframework.stereotype.Service;

@Service
public class GoogleAuthService {

    public String authenticateToken(String token) {
        // skip detail
        return "Google, authenticateToken with " + token;
    }

    public String revokeToken(String token) {
        // skip detail
        return "Google, revokeToken with " + token;
    }
}
