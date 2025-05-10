package com.alan.design.adapter_pattern;

import com.alan.design.adapter_pattern.adaptee.FacebookAuthService;
import com.alan.design.adapter_pattern.adaptee.GoogleAuthService;
import com.alan.design.adapter_pattern.adapter.AuthenticationAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class AdapterPatternTest {
    @Autowired
    private AuthenticationAdapterFactory authenticationAdapterFactory;

    @MockitoBean
    private GoogleAuthService googleAuthService;

    @MockitoBean
    private FacebookAuthService facebookAuthService;

    @Test
    void getAdapter() {
        // Adapter pattern usually combine with factory/strategy
        AuthenticationAdapter googleAdapter = authenticationAdapterFactory.getAdapter(AuthProvider.GOOGLE);
        AuthenticationAdapter facebookAdapter = authenticationAdapterFactory.getAdapter(AuthProvider.FACEBOOK);
        when(googleAuthService.authenticateToken(anyString())).thenReturn("googleInfo");
        when(facebookAuthService.checkToken(anyString())).thenReturn("facebookInfo");


        String googleAuthResult = googleAdapter.authenticate("12345678");
        String facebookAuthResult = facebookAdapter.authenticate("87654321");
        googleAdapter.revokeToken("12345678");
        facebookAdapter.revokeToken("87654321");


        assertEquals(googleAuthResult, "googleInfo");
        assertEquals(facebookAuthResult, "facebookInfo");
        verify(googleAuthService, times(1)).authenticateToken(anyString());
        verify(facebookAuthService, times(1)).checkToken(anyString());
        verify(googleAuthService, times(1)).revokeToken(anyString());
        verify(facebookAuthService, times(1)).logout(anyString());
    }
}