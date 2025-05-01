package com.alan.design.singletonpattern;

public class DoubleCheckedLockingSingleton {
    // Need 'volatile' here to ensure that changes to this object are immediately visible to all threads
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        // First check, no synchronized and high efficiency, prevent in most cases
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                // Second check, synchronized and low efficiency
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

}