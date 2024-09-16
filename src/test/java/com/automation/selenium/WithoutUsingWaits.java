package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithoutUsingWaits {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@id=\"start\"]//button")).click();
        Thread.sleep(5000);
        //WebElement str = driver.findElement(By.xpath("//div[@id=\"finish\"]//h4"));
        System.out.println(driver.findElement(By.xpath("//div[@id=\"finish\"]//h4")).getText());
    }
}
