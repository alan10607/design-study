package com.alan.design.proxy_pattern;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceProxy implements UserService {
    private final UserServiceImpl userService;
    private byte[] profilePictureCache;

    public byte[] loadProfilePicture() {
        // What proxy does: lazy load, protect data, cache

        // You can add validation here

        if (profilePictureCache == null) {
            profilePictureCache = userService.loadProfilePicture();
        }
        return profilePictureCache;
    }
}