package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUploadTask {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement fileUploadInput = driver.findElement(By.id("file-upload"));
        fileUploadInput.sendKeys("C:\\UST_Java\\Selenium\\src\\test\\resources\\screenshot\\image1.png");

        driver.findElement(By.id("file-submit")).click();
    }
}
