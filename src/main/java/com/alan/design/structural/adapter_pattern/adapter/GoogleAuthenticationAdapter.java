package com.alan.design.structural.adapter_pattern.adapter;

import com.alan.design.structural.adapter_pattern.AuthProvider;
import com.alan.design.structural.adapter_pattern.adaptee.GoogleAuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoogleAuthenticationAdapter implements AuthenticationAdapter {
    private final GoogleAuthService googleAuthService;

    @Override
    public AuthProvider getProviderName() {
        return AuthProvider.GOOGLE;
    }

    @Override
    public String authenticate(String token) {
        return googleAuthService.authenticateToken(token);
    }

    @Override
    public void revokeToken(String token) {
        googleAuthService.revokeToken(token);
    }
}
