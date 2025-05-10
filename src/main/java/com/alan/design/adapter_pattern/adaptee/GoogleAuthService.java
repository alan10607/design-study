package com.alan.design.adapter_pattern.adaptee;

import org.springframework.stereotype.Service;

@Service
public class GoogleAuthService {

    public String authenticateToken(String token) {
        return "GoogleInfo"; // skip detail
    }

    public void revokeToken(String token) {
        // skip detail
    }
}
