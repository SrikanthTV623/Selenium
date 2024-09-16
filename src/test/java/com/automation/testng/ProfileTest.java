package com.automation.testng;

import org.testng.annotations.Test;

public class ProfileTest {
    @Test(groups = "Smoke")
    public void Test10(){
        System.out.println("ProfileTest10");
    }
    @Test(groups = {"Smoke","completed"})
    public void Test11(){
        System.out.println("ProfileTest11");
    }
    @Test
    public void Test12(){
        System.out.println("ProfileTest12");
    }
    @Test
    public void Test13(){
        System.out.println("ProfileTest13");
    }
}
