package com.alan.design.structural.adapter_pattern.adapter;

import com.alan.design.structural.adapter_pattern.AuthProvider;

public interface AuthenticationAdapter {
    AuthProvider getProviderName();
    String authenticate(String token);
    void revokeToken(String token);
}