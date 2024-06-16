package io.loop.test.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    /*
    Navigate to Google search
    maximise the page
    get the title of the page
    get url of the page
    validate the title, expected title is "Google"

     */

    public static void main(String[] args) {
        //in Selenium 3 we had to set up the driver, for that we need webdrivermanager libraries
        //WebDriverManager.chromedriver().setup();

        //create driver object
        WebDriver driver = new ChromeDriver();

        //navigate to google
        driver.get("https://www.google.com/");

        //maximize
        driver.manage().window();

        //get the title of the page
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
    }
}
