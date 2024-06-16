package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToAmazon {

    /*
    navigate to amazon
    maximize
    navigate back
    navigate forward
    refresh
     */

    public static void main(String[] args) {

        //opens Chrome in a new window and shows Chrome is being controlled by automated test software
        WebDriver driver = new ChromeDriver();
        //navigate to amazon
        driver.navigate().to("https://www.amazon.com");
        //maximize the window
        driver.manage().window().maximize();
        //navigate back
        driver.navigate().back();
        //navigate forward
        driver.navigate().forward();
        //refresh
        driver.navigate().refresh();

        //closes the browser
        driver.quit();
    }
}
