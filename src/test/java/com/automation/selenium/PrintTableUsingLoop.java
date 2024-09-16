package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintTableUsingLoop {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();

        List<WebElement> list = driver.findElements(By.xpath("//table[@id=\"table1\"]//td[not(a)]"));
        //int size = list.size();

        /*
        //1st method
        for(int i=0;i< list.size();i++){
            if(i%5==0){
                System.out.println();
            }
            System.out.print(list.get(i).getText());
            System.out.print("   ");
        }
        */

        //2nd method
        int count =0;
        for(WebElement n:list){
            System.out.print(n.getText()+"  ");
            count++;
            if(count%5==0){
                System.out.println();
            }
        }


    }
}
