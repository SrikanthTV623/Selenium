package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class HandleFileUploadsUsingAutoIT {
    public static void main(String[] args) throws IOException {
        // AutoIT is a third-party tool used to handle OS-level pop-ups, such as file upload dialogs, which Selenium cannot interact with directly.
        // Steps to use AutoIT for file uploads:
        // 1. Download and install AutoIT from https://www.autoitscript.com/site/autoit/downloads/
        // 2. Create an AutoIT script to handle the file upload dialog.
        // 3. Compile the script into an executable (.exe) file.
        // 4. Call the executable from your Selenium test code when the file upload dialog appears.

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ilovepdf.com/pdf_to_jpg");

        // Click on the upload button to open the file dialog
        driver.findElement(By.cssSelector("a#pickfiles")).click();

        // Call the AutoIT executable to handle the file upload dialog
        Runtime.getRuntime().exec("C:\\Users\\Srikanth\\Documents\\FileUpload.exe");


        // Note: Ensure that the path to the AutoIT executable is correct and that the script is compiled properly.

    }
}
