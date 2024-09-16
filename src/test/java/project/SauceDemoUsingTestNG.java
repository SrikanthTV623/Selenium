package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoUsingTestNG extends BaseTest{
    @Test(dataProvider = "PositiveDataProvider")
    public void positiveTest(String[] cred){
        //String[] cred = credentials.split(" ");
        String username = cred[0];
        String password = cred[1];
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        //we check here whether it is logged in or not into the page using the
        //current url and the url checking
        //String expectedurl = "https://www.saucedemo.com/inventory.html";
        //Assert.assertEquals(driver.getCurrentUrl(),expectedurl);
        WebElement ele = driver.findElement(By.xpath("//a//div[text()='Sauce Labs Backpack']"));
        String result = ele.getText();
        String expected = "Sauce Labs Backpack";
        Assert.assertEquals(result,expected);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Test(dataProvider = "NegativeDataProvider")
    public void negativeTest(String[] cred){
        //String[] cred = credentials.split(" ");
        String username = cred[0];
        String password = cred[1];
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String expected = "Epic sadface";
        String[] ele = driver.findElement(By.tagName("h3")).getText().split(":");
        Assert.assertEquals(ele[0],expected);
    }

    @DataProvider(name="PositiveDataProvider")
    public Object[] getPositiveData(){
        Object[][] data = {{"standard_user", "secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
        return data;
    }
    @DataProvider(name="NegativeDataProvider")
    public Object[] getNegativeData(){
        Object[][] data = {{"locked_out_user", "secret_sauce"},
                {"locked_out_user", ""},
                {"srikanth",""},
                {" ","rtbtrfyguy"},
                {"sxdfcgvhb","dxfcgb"}
                };
        return data;
    }
}
