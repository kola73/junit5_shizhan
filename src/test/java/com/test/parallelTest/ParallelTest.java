package com.test.parallelTest;

import com.util.Calculator;
import org.junit.jupiter.api.RepeatedTest;

public class ParallelTest {
    @RepeatedTest(5)
    void testCount() throws InterruptedException {
        int result = Calculator.count(1);
        long id = Thread.currentThread().getId();
        System.out.println("线程号" + id + "为您计算当前报名人数为：" + result);
    }
        @RepeatedTest(5)
        void testSyncCount() throws InterruptedException {
            int result = Calculator.synCount(1);
            long id = Thread.currentThread().getId();
            System.out.println("线程号" + id + "为您计算当前报名人数为：" + result);
        }
}
