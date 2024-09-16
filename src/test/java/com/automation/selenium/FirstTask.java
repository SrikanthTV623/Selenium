package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("laptop");
        Thread.sleep(2000);
        //searchBox.sendKeys(Keys.ENTER);

        WebElement searchBtn = driver.findElement(By.id("gh-btn"));
        searchBtn.click();
        Thread.sleep(1000);

        Select drpCategoy = new Select(driver.findElement(By.name("_sacat")));
        drpCategoy.selectByVisibleText("Music");
        Thread.sleep(2000);

        searchBtn = driver.findElement(By.id("gh-btn"));
        searchBtn.click();

        driver.findElement(By.id("gh-as-a")).click();

        WebElement titleDescCheckBox = driver.findElement(By.name("LH_TitleDesc"));
        //titleDescCheckBox.click();
        WebElement lh_completeCheckBox = driver.findElement(By.name("LH_Complete"));
        //lh_completeCheckBox.click();
        WebElement lh_soldCheckBox = driver.findElement(By.name("LH_Sold"));
        //lh_soldCheckBox.click();

        if(!titleDescCheckBox.isSelected()){
            titleDescCheckBox.click();
        }
        if(!lh_completeCheckBox.isSelected()){
            lh_completeCheckBox.click();
        }
        if(!lh_soldCheckBox.isSelected()){
            lh_soldCheckBox.click();
        }

        driver.findElement(By.xpath("//div[@class='adv-form__actions']/button")).click();
        Thread.sleep(2000);

        //to print at values in all categories dropdown

        /*
        Select printDropDown = new Select(driver.findElement(By.id("gh-cat")));
        List<WebElement> list = printDropDown.getOptions();
        int size = list.size();
        for(int i =0;i<size;i++){
            System.out.println(list.get(i).getText());
        }
        */

        //Another Way
        List<WebElement> alloptions = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        for(WebElement option: alloptions){
            System.out.println(option.getText());
        }


    }
}
