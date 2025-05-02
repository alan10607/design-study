package com.alan.design.singleton_pattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertSame;

@Slf4j
class SingletonPatternTest {

    @Test
    void testSingletonIsSame() {
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        assertSame(eager1, eager2);
        printAddress(eager1, eager2);

        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        assertSame(lazy1, lazy2);
        printAddress(lazy1, lazy2);

        StaticInnerClassSingleton staticInnerClass1 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton staticInnerClass2 = StaticInnerClassSingleton.getInstance();
        assertSame(staticInnerClass1, staticInnerClass2);
        printAddress(staticInnerClass1, staticInnerClass2);

        DoubleCheckedLockingSingleton doubleCheckedLocking1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton doubleCheckedLocking2 = DoubleCheckedLockingSingleton.getInstance();
        assertSame(doubleCheckedLocking1, doubleCheckedLocking2);
        printAddress(doubleCheckedLocking1, doubleCheckedLocking2);

        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        assertSame(enum1, enum2);
        printAddress(enum1, enum2);
    }

    @Test
    public void testEagerSingletonTime() {
        benchmarkSingleton(EagerSingleton::getInstance);
    }

    @Test
    public void testLazySingletonTime() {
        benchmarkSingleton(LazySingleton::getInstance);
    }

    @Test
    public void testStaticInnerClassSingletonTime() {
        benchmarkSingleton(StaticInnerClassSingleton::getInstance);
    }

    @Test
    public void testDCLSingletonTime() {
        benchmarkSingleton(DoubleCheckedLockingSingleton::getInstance);
    }

    @Test
    public void testEnumSingletonTime() {
        benchmarkSingleton(() -> EnumSingleton.INSTANCE);
    }

    /**
     * Test getInstance 10_000_000 times
     *
     * @param singletonMethod getInstance method
     */
    private void benchmarkSingleton(Supplier<Object> singletonMethod) {
        String singletonName = singletonMethod.get().getClass().getSimpleName();
        int iterations = 10_000_000;

        // Warm-up (allow the JIT compiler to compile and optimize the method)
        for (int i = 0; i < 100_000; i++) {
            singletonMethod.get();
        }

        // Test start
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            singletonMethod.get();
        }
        long duration = System.nanoTime() - start;

        log.warn("{}: {} calls took {} ns (avg {} ns/call)",
                singletonName, iterations, duration, (double) duration / iterations);
    }

    private void printAddress(Object... objs) {
        List<Integer> hashCodes = Arrays.stream(objs)
                .map(System::identityHashCode)
                .toList();

        log.info("Class {} address are {}", objs[0].getClass().getSimpleName(), hashCodes);
    }
}