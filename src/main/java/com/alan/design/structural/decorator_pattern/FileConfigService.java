package com.alan.design.structural.decorator_pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class FileConfigService implements ConfigService {
    private final Map<String, String> mockedFileData = Map.of(
            "username", "admin",
            "password", "abc123"
    );

    @Override
    public String get(String key) {
        log.info("Load file, config key: {}", key);
        return mockedFileData.get(key);
    }
}