package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SauceDemoToReadAllItemsUsingForLoop {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        //login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        //to read every element in webpage
        List<WebElement> items = driver.findElements(By.xpath("//div//a//div[@data-test='inventory-item-name']"));
        for(int i =0;i<items.size(); i++){
            items = driver.findElements(By.xpath("//div//a//div[@data-test='inventory-item-name']"));

            WebElement item = items.get(i);
            //String itemName = item.getText();
            System.out.println(item.getText());
            item.click();

            System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
            System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText());
            System.out.println("=========================================");
            driver.findElement(By.id("back-to-products")).click();
        }

        //logout
        driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        /*
        //by doing like this we get stale execption so we should correct
        List<WebElement> items = driver.findElements(By.xpath("//div//a//div[@data-test='inventory-item-name']"));
        for(WebElement i : items){
            items = driver.findElements(By.xpath("//div//a//div[@data-test='inventory-item-name']"));
            WebElement item = items.get(i); //here required int not webelement so
            System.out.println(item.getText());
            item.click();
            System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
            System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText());
            driver.findElement(By.id("back-to-products")).click();
        }

         */


    }
}
