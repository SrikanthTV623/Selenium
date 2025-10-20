package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowAuthenticationPopUps {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Syntax: https://username:password@URL
        driver.get("https://admin:admin@https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Basic Auth")).click();


    }
}
