package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PrintTableUsingFunction {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();

        printTable("table1",driver);

        //driver.close();

    }
    public static void printTable(String id, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id="+id+"]//tbody//tr"))));
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='"+ id +"']//tbody//tr"));

        System.out.println(rows.size());
        for (int i = 1; i <= rows.size(); i++) {
            //List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + i + "]//td[not(a)]"));
            List<WebElement> cells = driver.findElements(By.xpath(String.format("//table[@id='"+ id +"']//tbody//tr[%s]//td[not(a)]",i)));

            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " ");
            }
            System.out.println();
        }
    }
}
