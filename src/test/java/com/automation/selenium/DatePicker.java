package com.automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatePicker {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.expedia.co.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        String checkInDate = "18 October 2024";
        String checkOutDate = "13 November 2024";
    }

    public static void selectDate(String date){
        String monthYear = date.substring(date.indexOf(' ')+1);
        String day = date.substring(0,date.indexOf(' '));
    }
}

