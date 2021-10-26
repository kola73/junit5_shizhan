package com.test.dynamicTestDemo.entity;

import lombok.Data;

@Data
// 定义yaml脚本参数
public class ShellTestResult {
    private String caseName;
    private boolean result;

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
