package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SaucedemoAutomation {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();

        System.out.println(driver.findElement(By.className("inventory_item_name")).getText());
        System.out.println(driver.findElement(By.className("inventory_item_desc")).getText());
        System.out.println(driver.findElement(By.className("inventory_item_price")).getText());

        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        driver.findElement(By.id("first-name")).sendKeys("Srikanth");
        driver.findElement(By.id("last-name")).sendKeys("TV");
        driver.findElement(By.id("postal-code")).sendKeys("515201");

        driver.findElement(By.id("continue")).click();

        System.out.println(driver.findElement(By.className("inventory_item_name")).getText());
        System.out.println(driver.findElement(By.className("inventory_item_desc")).getText());
        System.out.println(driver.findElement(By.className("inventory_item_price")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='summary_info']/div[2]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='summary_info']/div[4]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='summary_info']/div[6]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='summary_info']/div[7]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='summary_info']/div[8]")).getText());

        driver.findElement(By.xpath("//div[@class='cart_footer']//button[2]")).click();

        System.out.println(driver.findElement(By.className("complete-header")).getText());
        System.out.println(driver.findElement(By.className("complete-text")).getText());


    }
}
