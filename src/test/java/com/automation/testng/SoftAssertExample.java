package com.automation.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

    @Test
    public void softAssertTest(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(10,10);
        softAssert.assertEquals(11,12);
        softAssert.assertEquals(25,12);
        softAssert.assertTrue(11>=50);
        softAssert.assertAll();
    }
}
