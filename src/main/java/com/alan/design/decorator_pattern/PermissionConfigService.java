package com.alan.design.decorator_pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PermissionConfigService implements ConfigService {
    private final UserRole userRole;
    private final ConfigService subject;

    PermissionConfigService(ConfigService subject, UserRole userRole) {
        this.subject = subject;
        this.userRole = userRole;
    }

    @Override
    public String get(String key) {
        log.info("Check permission, config key: {}", key);
        if (userRole != UserRole.ADMIN) {
            throw new SecurityException("No permission");
        }

        return subject.get(key);
    }
}