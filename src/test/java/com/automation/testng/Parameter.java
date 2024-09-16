package com.automation.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
    @Parameters({"browser","Hello"})
    @Test
    public void test1(String browser,String Hello){
        System.out.println(browser+" "+Hello);
    }
}
