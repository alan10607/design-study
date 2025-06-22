package com.alan.design.structural.adapter_pattern;

import com.alan.design.structural.adapter_pattern.adapter.AuthenticationAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AdapterPatternTest {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationAdapterFactory authenticationAdapterFactory;


    @Test
    void getAdapterByStrategy() {
        // Adapter pattern usually combine with factory/strategy
        AuthInfo googleAuthInfo = new AuthInfo(AuthProvider.GOOGLE, "1234");
        AuthInfo facebookAuthInfo = new AuthInfo(AuthProvider.FACEBOOK, "5678");

        assertEquals(authenticationService.authenticate(googleAuthInfo),
                "Google, authenticateToken with " + googleAuthInfo.getToken());
        assertEquals(authenticationService.revokeToken(googleAuthInfo),
                "Google, revokeToken with " + googleAuthInfo.getToken());

        assertEquals(authenticationService.authenticate(facebookAuthInfo),
                "Facebook, checkToken with " + facebookAuthInfo.getToken());
        assertEquals(authenticationService.revokeToken(facebookAuthInfo),
                "Facebook, logout with " + facebookAuthInfo.getToken());
    }

    @Test
    void getAdapterByFactory() {
        AuthenticationAdapter googleAdapter = authenticationAdapterFactory.getAdapter(AuthProvider.GOOGLE);
        AuthenticationAdapter facebookAdapter = authenticationAdapterFactory.getAdapter(AuthProvider.FACEBOOK);

        assertEquals(googleAdapter.authenticate("1234"), "Google, authenticateToken with 1234");
        assertEquals(googleAdapter.revokeToken("1234"), "Google, revokeToken with 1234");

        assertEquals(facebookAdapter.authenticate("5678"), "Facebook, checkToken with 5678");
        assertEquals(facebookAdapter.revokeToken("5678"), "Facebook, logout with 5678");
    }
}