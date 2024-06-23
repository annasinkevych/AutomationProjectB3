package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample {

    //you can add plugins here with ChromeOptions
    public static void main(String[] args) {
        //before creating a driver object we need to create and object of chrome Options

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        //starts the browser already maximized
        WebDriver driver = new ChromeDriver(options);

        //navigate to google
        driver.get("https://www.google.com");


        driver.quit();
    }
}
