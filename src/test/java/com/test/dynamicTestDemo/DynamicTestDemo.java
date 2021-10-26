package com.test.dynamicTestDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.test.dynamicTestDemo.entity.ShellTestResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestDemo {
    // demo
    @TestFactory
    Collection<DynamicTest> dynamicTestCollection() {
        return Arrays.asList(
                dynamicTest("1st dynamic test", () -> {
                    Assertions.assertTrue(true);
                    System.out.println("this is a dynamicTest");
                }),
                dynamicTest("2nd dynamic test", () -> assertEquals(4, 4))
        );
    }

    @Test
    void entityTest() throws IOException {
        // 读取yaml文件并把它变成一个对象
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.readValue(new File("D:\\junit5shizhan\\src\\main\\resources\\shell_test_result.yaml"), ResultList.class);
        System.out.println("done!");
    }

    @TestFactory
    Collection<DynamicTest> tstShellResultYamlFile() throws IOException {
        List<DynamicTest> dynamicTestList = new ArrayList<>();
        //反序列化yaml数据到对象列表中
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ResultList resultList = mapper.readValue(new File("src/main/resources/shell_test_result.yaml"), ResultList.class);
        //动态遍历生成测试方法
        for (ShellTestResult shellTestResult : resultList.getResultList()) {
            //动态生成测试方法代码
            DynamicTest dynamicTest = dynamicTest(
                    shellTestResult.getCaseName(),
                    () -> assertTrue(shellTestResult.isResult()));
            //收集操作
            dynamicTestList.add(dynamicTest);
        }
        return dynamicTestList;
    }

}
