package com.alan.design.creational.singleton_pattern;

public class EagerSingleton {
    // Instance is created when the class is loaded, which may cause memory waste
    private final static EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

}