package com.automation.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        //button[text()='Click for JS Confirm']
        WebElement clickBtn1 = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickBtn1.click();

        Alert alert1 = driver.switchTo().alert();
        String alertMessage1 = driver.switchTo().alert().getText();
        System.out.println(alertMessage1);
        alert1.accept();

        //to cancel & print alert message
        WebElement clickBtn2 = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        clickBtn2.click();

        Alert alert2 = driver.switchTo().alert();
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);
        alert2.dismiss();

        //we should enter value and accept
        WebElement clickBtn3 = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        clickBtn3.click();

        Alert alert3 = driver.switchTo().alert();
        String alertMessage3 = driver.switchTo().alert().getText();
        System.out.println(alertMessage3);
        alert3.sendKeys("hello");
        alert3.accept();


    }
}
