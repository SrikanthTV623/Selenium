package com.automation.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderTask {
    @Test(dataProvider = "PositiveDataProvider")
    public void test1(String amount){
        System.out.println("Positive test with "+amount);
    }
    @Test(dataProvider = "NegativeDataProvider")
    public void test2(String amount){
        System.out.println("Negative test with "+amount);
    }
    @DataProvider(name="NegativeDataProvider")
    public Object[] getNegativeData(){
        Object[] data = {"0.9",".5","100.1","abc","10/3","0.00001"};
        return data;

    }
    @DataProvider(name="PositiveDataProvider")
    public Object[] getPositiveData(){
        Object[] data = {"1","100","1.1","1.001","3","99.9"};
        return data;
    }
}
