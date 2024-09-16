package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class JavaScriptExeforPageScroll {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://ebay.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.id("gh-ac")).sendKeys("Laptop");
        driver.findElement(By.id("gh-btn")).click();
        for(int i=1;i<=10;i++){
            JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
            javaScriptExecutor.executeScript("window.scrollBy(0,250)");
            Thread.sleep(1000);
        }
    }
}
