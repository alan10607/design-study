package com.alan.design.structural.decorator_pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CacheConfigService implements ConfigService {
    private final Map<String, String> cache = new HashMap<>();
    private final ConfigService subject;

    CacheConfigService(ConfigService subject) {
        this.subject = subject;
    }

    @Override
    public String get(String key) {
        if (cache.containsKey(key)) {
            log.info("Cache config, config key: {}", key);
            return cache.get(key);
        } else {
            String config = subject.get(key);
            cache.put(key, config);
            return config;
        }
    }

    public Map<String, String> getCache() { // for test
        return cache;
    }
}