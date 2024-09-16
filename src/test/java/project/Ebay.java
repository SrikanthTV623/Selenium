package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Ebay {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.id("gh-ac")).sendKeys("Laptop");
        WebElement searchbtn = driver.findElement(By.id("gh-btn"));
        searchbtn.click();

        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class=\"srp-results srp-list clearfix\"]//div[@class=\"s-item__title\"]"));
        for(WebElement ele:elements)
        {
            System.out.println(ele.findElement(By.xpath("./span")).getText());
            ele.click();
            String currentWindow = driver.getWindowHandle();
            Set<String> listOfWindows = driver.getWindowHandles();
            for (String s : listOfWindows) {
                if (!currentWindow.equals(s)) {
                    driver.switchTo().window(s);
                    System.out.println(driver.findElement(By.xpath("//h1[@class='x-item-title__mainTitle']/span")).getText());
                    System.out.println(driver.findElement(By.xpath("//div[@class='x-price-primary']/span")).getText());
                }
            }
            System.out.println("=====================================");
            driver.close();
            driver.switchTo().window(currentWindow);
        }
    }
}
