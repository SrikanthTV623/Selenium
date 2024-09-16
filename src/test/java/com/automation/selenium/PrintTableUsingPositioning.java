package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class PrintTableUsingPositioning {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();

        List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[4]//td[not(a)]"));
        for (WebElement i : list) {
            System.out.println(i.getText() + " ");
        }

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));

        for (int i = 1; i <= rows.size(); i++) {
            //List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + i + "]//td[not(a)]"));
            List<WebElement> cells = driver.findElements(By.xpath(String.format("//table[@id='table1']//tbody//tr[%s]//td[not(a)]",i)));

            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " ");
            }
            System.out.println();
        }
    }
}
