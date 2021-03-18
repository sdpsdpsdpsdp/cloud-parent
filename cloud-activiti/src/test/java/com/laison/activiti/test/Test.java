package com.laison.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/9 19:59
 */
public class Test {
    @org.junit.Test
    public void test() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);

    }
}
