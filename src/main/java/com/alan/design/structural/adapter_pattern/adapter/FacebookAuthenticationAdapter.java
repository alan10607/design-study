package com.alan.design.structural.adapter_pattern.adapter;

import com.alan.design.structural.adapter_pattern.AuthProvider;
import com.alan.design.structural.adapter_pattern.adaptee.FacebookAuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FacebookAuthenticationAdapter implements AuthenticationAdapter {
    private final FacebookAuthService facebookAuthService;

    @Override
    public AuthProvider getProviderName() {
        return AuthProvider.FACEBOOK;
    }

    @Override
    public String authenticate(String token) {
        return facebookAuthService.checkToken(token);
    }

    @Override
    public void revokeToken(String token) {
        facebookAuthService.logout(token);
    }
}
