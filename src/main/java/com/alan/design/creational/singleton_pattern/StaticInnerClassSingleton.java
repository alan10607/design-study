package com.alan.design.creational.singleton_pattern;

public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    // Lazy Initialization + thread-safe, but can't pass arguments to constructor
    private static class Holder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static synchronized StaticInnerClassSingleton getInstance() {
        return Holder.INSTANCE;
    }

}