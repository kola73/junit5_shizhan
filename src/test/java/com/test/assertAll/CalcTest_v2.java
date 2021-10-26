package com.test.assertAll;

import com.util.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 但是这样也有个问题，如果我想要参数化操作，还是会出现刚刚的情况，报错后后面的都无法执行。
 * 查看assetAll api，里面有个Collection<Executable>参数，
 * 所以可以把可执行代码块存到一个集合里面，然后把集合作为一个入参去assertAll
 */
public class CalcTest_v2 {
    // 解决方案：软断言
    @Test
    void addTest_v2() {
        try {
            int result1 = Calculator.add(4, 2);
            System.out.println("结果是：" + result1);
//            assertEquals(2, result1);
            int result2 = Calculator.add(4, 2);
            System.out.println("结果是：" + result2);
//            assertEquals(2, result2);
            int result3 = Calculator.add(4, 2);
            System.out.println("结果是：" + result3);
//            assertEquals(2, result3);
            assertAll("加法计算器结果校验",
                    () -> assertEquals(2, result1),
                    () -> assertEquals(2, result1),
                    () -> assertEquals(2, result1)
            );
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}
