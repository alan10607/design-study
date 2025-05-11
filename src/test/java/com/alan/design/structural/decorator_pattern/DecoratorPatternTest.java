package com.alan.design.structural.decorator_pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorPatternTest {

    @Test
    void testFileConfigService() {
        FileConfigService fileConfigService = new FileConfigService();
        assertEquals(fileConfigService.get("username"), "admin");
        assertEquals(fileConfigService.get("password"), "abc123");
    }

    @Test
    void testCacheConfigService() {
        CacheConfigService cacheConfigService = new CacheConfigService(new FileConfigService());
        assertEquals(cacheConfigService.get("username"), "admin");
        assertEquals(cacheConfigService.get("password"), "abc123");
        assertEquals(cacheConfigService.get("username"), "admin"); // use cache
        assertEquals(cacheConfigService.get("password"), "abc123"); // use cache
        assertEquals(cacheConfigService.getCache().get("username"), "admin");
        assertEquals(cacheConfigService.getCache().get("password"), "abc123");
    }

    @Test
    void testLoggingConfigService() {
        LoggingConfigService loggingConfigService = new LoggingConfigService(new FileConfigService());
        assertFalse(loggingConfigService.isLogged());
        assertEquals(loggingConfigService.get("username"), "admin");
        assertEquals(loggingConfigService.get("password"), "abc123");
        assertTrue(loggingConfigService.isLogged());
    }

    @Test
    void testPermissionConfigService() {
        PermissionConfigService adminPermissionConfigService = new PermissionConfigService(new FileConfigService(), UserRole.ADMIN);
        assertEquals(adminPermissionConfigService.get("username"), "admin");
        assertEquals(adminPermissionConfigService.get("password"), "abc123");


        PermissionConfigService normalPermissionConfigService = new PermissionConfigService(new FileConfigService(), UserRole.NORMAL);
        assertThrows(SecurityException.class,
                () -> normalPermissionConfigService.get("username"),
                "No permission");
        assertThrows(SecurityException.class,
                () -> normalPermissionConfigService.get("password"),
                "No permission");
    }

    @Test
    void testLoggingCacheConfigService() {
        LoggingConfigService loggingCacheConfigService = new LoggingConfigService(new CacheConfigService(new FileConfigService()));
        assertFalse(loggingCacheConfigService.isLogged());
        assertEquals(loggingCacheConfigService.get("username"), "admin");
        assertEquals(loggingCacheConfigService.get("password"), "abc123");
        assertTrue(loggingCacheConfigService.isLogged());
        // skip assert CacheConfigService.getCache()


        CacheConfigService cacheLoggingConfigService = new CacheConfigService(new LoggingConfigService(new FileConfigService()));
        assertEquals(cacheLoggingConfigService.get("username"), "admin");
        assertEquals(cacheLoggingConfigService.get("password"), "abc123");
        assertEquals(cacheLoggingConfigService.getCache().get("username"), "admin");
        assertEquals(cacheLoggingConfigService.getCache().get("password"), "abc123");
        // skip assert LoggingConfigService.isLogged()
    }

    @Test
    void testPermissionLoggingCacheConfigService() {
        PermissionConfigService adminPermissionLoggingCacheConfigService = new PermissionConfigService(new LoggingConfigService(new CacheConfigService(new FileConfigService())), UserRole.ADMIN);
        assertEquals(adminPermissionLoggingCacheConfigService.get("username"), "admin");
        assertEquals(adminPermissionLoggingCacheConfigService.get("password"), "abc123");
        // skip assert CacheConfigService.getCache()
        // skip assert LoggingConfigService.isLogged()


        PermissionConfigService normalPermissionLoggingCacheConfigService = new PermissionConfigService(new LoggingConfigService(new CacheConfigService(new FileConfigService())), UserRole.NORMAL);
        assertThrows(SecurityException.class,
                () -> normalPermissionLoggingCacheConfigService.get("username"),
                "No permission");
        assertThrows(SecurityException.class,
                () -> normalPermissionLoggingCacheConfigService.get("password"),
                "No permission");
        // skip assert CacheConfigService.getCache()
        // skip assert LoggingConfigService.isLogged()
    }

}