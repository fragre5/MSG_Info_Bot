package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String driverPath = properties.getProperty("driverPath");

        String url = properties.getProperty("url");

        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement element = driver.findElement(By.className("body"));

        System.out.println(element.getTagName());

        driver.quit();


    }
}