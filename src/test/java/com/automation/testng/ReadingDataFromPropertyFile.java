package com.automation.testng;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadingDataFromPropertyFile {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/test/resources/data/config.properties"));
        System.out.println(properties.getProperty("login.username"));
    }
}
