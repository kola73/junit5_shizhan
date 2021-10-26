package com.test.assertAll;

import com.util.Calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest_v3 {
    @Test
    void addTest() throws InterruptedException {
        List<Executable> assertList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int result = Calculator.add(0, i);
            System.out.println("加法计算结果是：" + result);
            // 先把结果存起来,这样就不会中断了
            assertList.add(() -> assertEquals(4, result));
        }
        // 统一进行校验
       assertAll("加法计算结果校验", assertList.stream());
    }
}
