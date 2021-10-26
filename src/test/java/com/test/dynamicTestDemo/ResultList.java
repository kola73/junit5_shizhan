package com.test.dynamicTestDemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.dynamicTestDemo.entity.ShellTestResult;
import lombok.Data;

import java.util.List;

// 定义一个存放结果的list列表
//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResultList {
    private List<ShellTestResult> resultList;

    public List<ShellTestResult> getResultList() {
        return resultList;
    }

    public void setResultList(List<ShellTestResult> resultList) {
        this.resultList = resultList;
    }
}
