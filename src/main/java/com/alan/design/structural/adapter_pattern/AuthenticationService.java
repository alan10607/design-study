package com.alan.design.structural.adapter_pattern;

import com.alan.design.structural.adapter_pattern.adapter.AuthenticationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {
    private final Map<AuthProvider, AuthenticationAdapter> adapterMap;

    @Autowired
    public AuthenticationService(List<AuthenticationAdapter> adapters) {
        this.adapterMap = adapters.stream()
                .collect(Collectors.toMap(AuthenticationAdapter::getProviderName, Function.identity()));
    }

    public String authenticate(AuthInfo authInfo) {
        return getAdapter(authInfo.getAuthProvider()).authenticate(authInfo.getToken());
    }

    public String revokeToken(AuthInfo authInfo) {
        return getAdapter(authInfo.getAuthProvider()).revokeToken(authInfo.getToken());
    }

    private AuthenticationAdapter getAdapter(AuthProvider authProvider) {
        return adapterMap.get(authProvider);
    }
}