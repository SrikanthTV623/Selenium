package com.automation.testng;

import org.testng.annotations.Test;

public class HomeTest {
    @Test(groups = "Smoke")
    public void Test6(){
        System.out.println("HomeTest6");
    }
    @Test(groups = {"Smoke","completed"})
    public void Test7(){
        System.out.println("HomeTest7");
    }
    @Test
    public void Test8(){
        System.out.println("HomeTest8");
    }
    @Test
    public void Test9(){
        System.out.println("HomeTest9");
    }
}
