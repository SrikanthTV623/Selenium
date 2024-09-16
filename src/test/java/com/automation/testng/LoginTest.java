package com.automation.testng;

import org.testng.annotations.Test;

public class LoginTest {
    @Test(groups = "Smoke")
    public void Test1(){
        System.out.println("LoginTest1");
    }
    @Test(groups = "Smoke")
    public void Test2(){
        System.out.println("LoginTest2");
    }
    @Test(groups = {"Smoke","completed"})
    public void Test3(){
        System.out.println("LoginTest3");
    }
    @Test
    public void Test4(){
        System.out.println("LoginTest4");
    }
    @Test
    public void Test5(){
        System.out.println("LoginTest5");
    }
}
