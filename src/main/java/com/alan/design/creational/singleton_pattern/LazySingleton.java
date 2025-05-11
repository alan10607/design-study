package com.alan.design.creational.singleton_pattern;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    // Need synchronized, low efficiency
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}