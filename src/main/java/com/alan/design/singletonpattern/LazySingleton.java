package com.alan.design.singletonpattern;

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