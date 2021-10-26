package com.test.launcher;

import com.test.parallelTest.ParallelTest;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryListener;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class Junit5Demo_5_1Launcher {
    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                //通过对包、类、方法维度的选择器，制定要执行的脚本
                .selectors(
                         selectClass(ParallelTest.class)
                       //  selectMethod("examples.packageA.ClassATest#testCaseA")
                )
                .filters(
                        //通过对类名的通配符匹配，制定或者排除相关用例
                        // excludeClassNamePatterns(".*ATest")
//                        includeClassNamePatterns(".*ATest")

                )
                .build();
        Launcher launcher = LauncherFactory.create();
        TestExecutionListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }
}
