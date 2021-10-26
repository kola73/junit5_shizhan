package com.test.assertAll;

import com.util.Calculator;
import org.junit.jupiter.api.Test;


public class CalcTest {
    /**
     * 问题：只要有一个报错，底下的就执行不了
     * 解决方案：软断言（即使一个断言失败，仍然会继续执行余下断言，然后统一输出所有断言结果(见v2）
     * 实施方案：可以使用junit5提供的lambda断言，即使个断言失败，仍然会继续执行余下断言，然后统一输出所有断言结果
     */
    @Test
    void addTest() {
        try {
            int result1 = Calculator.add(4, 2);
            System.out.println("结果是：" + result1);
//            assertEquals(2, result1);
            int result2 = Calculator.add(4, 2);
            System.out.println("结果是：" + result2);
//            assertEquals(2, result2);
            int result3 = Calculator.add(4, 2);
            System.out.println("结果是：" + result3);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }


}
