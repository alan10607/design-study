package com.alan.design.proxy_pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProxyPatternTest {
    @InjectMocks
    private UserServiceProxy userServiceProxy;
    @Mock
    private UserServiceImpl userServiceImpl;

    @Test
    void testLoadProfilePicture() {
        byte[] mockImage = new byte[]{1, 2, 3, 4, 5};
        when(userServiceImpl.loadProfilePicture()).thenReturn(mockImage);

        byte[] firstLoaded = userServiceProxy.loadProfilePicture();
        assertEquals(mockImage, firstLoaded);
        verify(userServiceImpl, times(1)).loadProfilePicture();

        byte[] secondLoaded = userServiceProxy.loadProfilePicture();
        assertEquals(mockImage, secondLoaded);
        verify(userServiceImpl, times(1)).loadProfilePicture();
    }
}