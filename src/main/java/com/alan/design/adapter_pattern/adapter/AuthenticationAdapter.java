package com.alan.design.adapter_pattern.adapter;

import com.alan.design.adapter_pattern.AuthProvider;

public interface AuthenticationAdapter {
    AuthProvider getProviderName();
    String authenticate(String token);
    void revokeToken(String token);
}