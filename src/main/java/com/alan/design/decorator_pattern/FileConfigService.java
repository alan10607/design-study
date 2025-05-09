package com.alan.design.decorator_pattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
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