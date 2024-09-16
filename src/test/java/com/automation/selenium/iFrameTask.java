package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class iFrameTask {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        //driver.findElement(By.xpath("//div[@class='tox-icon']")).click();
        //System.out.println(driver.findElement(By.xpath("//div[@class=\"example\"]/h3")).getText());

        /*WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        WebElement content = driver.findElement(By.xpath("//p"));
        System.out.println(content.getText());*/


        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        WebElement content = driver.findElement(By.xpath("//body[@id=\"tinymce\"]/p"));
        System.out.println(content.getText());

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());


    }
}
