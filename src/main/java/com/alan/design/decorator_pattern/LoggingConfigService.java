package com.alan.design.decorator_pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingConfigService implements ConfigService {
    private final ConfigService subject;

    private boolean logged = false; // for test

    LoggingConfigService(ConfigService subject) {
        this.subject = subject;
    }

    @Override
    public String get(String key) {
        String config = subject.get(key);

        log.info("Print log, config key: {}", key);
        setLogged(true);

        return config;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}