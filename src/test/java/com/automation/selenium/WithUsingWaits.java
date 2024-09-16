package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WithUsingWaits {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //explicit wait
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@id=\"start\"]//button")).click();
        WebElement elem = driver.findElement(By.xpath("//div[@id=\"finish\"]//h4"));
        //for 1 implicit wait text is not available, explicit wait is used
        //explicit wait syntax
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(elem));
        System.out.println(elem.getText());

        //implicit wait
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.manage().window().maximize();
        //for 2 implicit wait text is available
        //implicit wait syntax
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebElement strtBtn = driver.findElement(By.xpath("//div[@id=\"start\"]//button"));
        strtBtn.click();
        WebElement text = driver.findElement(By.xpath("//div[@id=\"finish\"]//h4"));
        System.out.println(text.getText());

        //driver.close();
    }
}
