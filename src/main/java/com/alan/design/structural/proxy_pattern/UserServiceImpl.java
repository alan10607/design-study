package com.alan.design.structural.proxy_pattern;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public byte[] loadProfilePicture() {
        // skip file loading
        return new byte[0];
    }
}