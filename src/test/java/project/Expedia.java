package project;

import com.sun.security.jgss.GSSUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Expedia {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.expedia.co.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        //click flight
        driver.findElement(By.xpath("//li[2]//span[@class='uitk-tab-text']")).click();

        //to select from place - thiruvanthapuram
        driver.findElement(By.xpath("//button[@aria-label=\"Leaving from\"]")).click();
        WebElement form = driver.findElement(By.id("origin_select"));
        form.sendKeys("Thiruvanthapuram");
        driver.findElement(By.xpath("//button[@class=\"uitk-button uitk-button-medium uitk-button-fullWidth has-subtext origin_select-result-item-button result-item-button\"]")).click();

        //to select to place - bengaluru
        driver.findElement(By.xpath("//button[@aria-label=\"Going to\"]")).click();
        WebElement to = driver.findElement(By.id("destination_select"));
        to.sendKeys("Bengaluru");
        driver.findElement(By.xpath("//button[@aria-label=\"Bengaluru (BLR - Kempegowda Intl.) India\"]")).click();

        //click on the date button
        driver.findElement(By.xpath("//button[@data-testid=\"uitk-date-selector-input1-default\"]")).click();

        //selecting the dates from when to when
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@class='uitk-day-aria-label'][contains(@aria-label,'Saturday 20 July 2024')]/following-sibling::div")));
        javascriptExecutor.executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@class='uitk-day-aria-label'][contains(@aria-label,'Friday 26 July 2024')]/following-sibling::div")));

        //click done
        driver.findElement(By.xpath("//button[@data-stid='apply-date-selector']")).click();

        //click search
        driver.findElement(By.xpath("//button[@id='search_button']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//li[@data-test-id='offer-listing']"));

        //to load all flights from that page
        //because of loading issue we did this
        while(elements.size()<12){
            elements = driver.findElements(By.xpath("//li[@data-test-id='offer-listing']"));
        }

        for(WebElement ele:elements){
            WebElement arriveTime = ele.findElement(By.xpath(".//div[@data-test-id='arrival-time']//span"));
            System.out.print(arriveTime.getText()+" ");
            WebElement price = ele.findElement(By.xpath(".//span[@class='uitk-lockup-price']"));
            System.out.print(price.getText()+" ");
            WebElement company = ele.findElement(By.xpath(".//div[@class='uitk-text truncate-lines-2 uitk-type-200 uitk-text-default-theme']"));
            System.out.print(company.getText()+" ");
            WebElement duration = ele.findElement(By.xpath(".//div[@data-test-id='journey-duration']"));
            System.out.print(duration.getText()+" ");
            System.out.println();
        }
    }
}
