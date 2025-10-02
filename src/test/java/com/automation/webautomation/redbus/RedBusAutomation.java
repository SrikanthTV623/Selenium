package com.automation.webautomation.redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RedBusAutomation {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement fromLocation = driver.findElement(By.xpath("//div[contains(text(),'From')]"));
        fromLocation.click();

        WebElement fromLocationText = driver.findElement(By.cssSelector("input#srcDest"));
        fromLocationText.sendKeys("Bang");

        By locatorForDropDownFrom = By.xpath("//div[@id='suggestions-status']//following-sibling::div[2]/div/div");
        waitForElement(driver,locatorForDropDownFrom);

        WebElement selectFromLocFromDropDown = driver.findElement(By.xpath("//div[@id='suggestions-status']//following-sibling::div[2]/div/div[3]/div/div/div[contains(@aria-label,'Bangalore')]"));
        jsClick(driver,selectFromLocFromDropDown);

        WebElement toLocation = driver.findElement(By.xpath("//div[contains(text(),'To')]"));
        jsClick(driver,toLocation);

        WebElement toLocationText = driver.findElement(By.cssSelector("input#srcDest"));
        toLocationText.sendKeys("Hyd");

        WebElement selectToLocFromDropDown = driver.findElement(By.xpath("//div[@id='suggestions-status']//following-sibling::div[2]/div/div[3]/div/div/div[contains(@aria-label,'Hyderabad')]"));
        selectToLocFromDropDown.click();

        WebElement clickOnDate = driver.findElement(By.xpath("//span[contains(text(),\"Date\")]"));
        clickOnDate.click();

        String date = "10";
        String monthAndYear = "December 2025";
        String gettingMonthAndYearDisplayedText = driver.findElement(By.xpath("//div[@aria-label=\"Date picker\"]/div/div[1]/div/p[contains(@class,'monthYear')]")).getText();
        System.out.println(gettingMonthAndYearDisplayedText);

        while(true){
            if(monthAndYear.equals(gettingMonthAndYearDisplayedText)){
                WebElement selectDate = driver.findElement(By.xpath("//div[@aria-label='Date picker']//div/ul//span[text()='"+date+"']"));
                selectDate.click();
                break;
            }else {
                WebElement nextButtonForNextMonth = driver.findElement(By.xpath("//div[@aria-label=\"Date picker\"]/div//i[contains(@aria-label,'Next')]"));
                nextButtonForNextMonth.click();
            }
            gettingMonthAndYearDisplayedText = driver.findElement(By.xpath("//div[@aria-label=\"Date picker\"]/div/div[1]/div/p[contains(@class,'monthYear')]")).getText();
            System.out.println(gettingMonthAndYearDisplayedText);
        }

        WebElement searchButton = driver.findElement(By.cssSelector("[class*='icon-search']"));
        searchButton.click();

        WebElement selectFirstOptionFromResults = driver.findElement(By.xpath("//ul//li[1]"));
        selectFirstOptionFromResults.click();

        List<WebElement> seatsAvailableList = driver.findElements(By.cssSelector("[aria-label*='seat status available']"));

        for (WebElement seat : seatsAvailableList){
            String seatsNames = seat.getAttribute("aria-label");
            System.out.println(seatsNames);
        }

        //driver.close();
    }

    public static void jsClick(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void waitForElement(WebDriver driver,By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void waitForElementToBeClickable(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
