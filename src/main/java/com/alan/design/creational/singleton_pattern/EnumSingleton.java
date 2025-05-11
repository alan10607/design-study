package com.alan.design.creational.singleton_pattern;

public enum EnumSingleton {
    // Not lazy initialization may cause memory waste, can't pass arguments to constructor
    INSTANCE;

    public void doSomething() {
        // Enum method here
    }
}