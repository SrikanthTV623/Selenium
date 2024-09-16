package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class OrangeHRM {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        //Login into orangeHRM
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");
        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.click();

        //Select Admin
        driver.findElement(By.xpath("//ul//li[1]//a[@class='oxd-main-menu-item']")).click();

        //Click Add button to add new login username & password
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();

        //select user role as ess
        driver.findElement(By.xpath("//div[@class='oxd-select-text--after']")).click();
        driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/div[3]")).click();

        //employee name
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("virat");
        driver.findElement(By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']/div/span")).click();

        //click status and select enabled
        driver.findElement(By.xpath("//label[contains(text(),'Status')]/../following-sibling::div/div/div")).click();
        driver.findElement(By.xpath("//div[@class='oxd-select-option'][2]/span[text()='Enabled']")).click();

        //username is created using random function in java
        Random random = new Random();
        int rand = random.nextInt(1000); //random number will be generated bwteen 1 to 1000
        String user = "Virat"+rand;
        WebElement userName = driver.findElement(By.xpath("//label[contains(text(),'Username')]/../following-sibling::div/input"));
        userName.click();
        userName.sendKeys(user);

        //password
        String pass = "Virat@18";
        WebElement passWord = driver.findElement(By.xpath("//label[text()='Password']/../following-sibling::div/input"));
        passWord.click();
        passWord.sendKeys(pass);

        //confirm password
        WebElement conPass = driver.findElement(By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input"));
        conPass.click();
        conPass.sendKeys(pass);

        //click save button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(6000);

        //logout
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a")).click();

        //login
        //fetch the new username & password for login
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
        driver.findElement(By.tagName("button")).click();

        //checked whether user is created successfully
        Assert.assertEquals("Virat Kohli",driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText());

        //logout
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a")).click();

        //Login into orangeHRM with old credentials
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();

        //Select Admin
        driver.findElement(By.xpath("//ul//li[1]//a[@class='oxd-main-menu-item']")).click();

        //deleting the user
        driver.findElement(By.xpath("//div[text()='"+user+"']/../..//div[@class='oxd-table-cell-actions']//i[@class='oxd-icon bi-trash']")).click();
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']/..")).click();

        List<WebElement> usernames = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
        for(int i=1;i<=usernames.size();i++){
            String actual = driver.findElement(By.xpath("//div[@class='oxd-table-body']/div["+i+"]/div/div[2]/div")).getText();
            Thread.sleep(1000);
            if(!user.equals(actual)){
                System.out.println(actual);
            }
        }

        //logout
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a")).click();
    }
}
