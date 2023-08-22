package org.example;

import org.example.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    static String film = Utils.readFileFilmName();

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

        WebElement findFilm = driver.findElement(By.name("kp_query"));

        WebElement buttonFind = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/header/div/div[2]/div[2]/div/form/div/div/button"));

        findFilm.sendKeys(film);

        buttonFind.click();

        WebElement film = driver.findElement(By.xpath("//*[@id=\"block_left_pad\"]/div/div[2]/div/p/a"));

        film.click();

        Utils.sleep(50000);

        driver.quit();

    }
}