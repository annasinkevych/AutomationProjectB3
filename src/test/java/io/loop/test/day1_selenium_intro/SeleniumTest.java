package io.loop.test.day1_selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        //Before Selenium 4, we load dependencies for webdriver manager Boni Garcia
        //WebDriverManager.chromedriver().setup();

        //opens Chrome in a new window and shows Chrome is being controlled by automated test software
        WebDriver driver = new ChromeDriver();
        //maximise the window
        driver.manage().window().maximize();

        //another maximise method - NOT RECOMMENDED AS IT WORKS ONLY ON SOME MAC and Windows machines
        //driver.manage().window().fullscreen();

        //navigate to the web page
        driver.get("https://www.loopcamp.io");

        Thread.sleep(5000);
        //another navigate method
        driver.navigate().to("https://www.etsy.com");

        //navigate back
        driver.navigate().back();
        Thread.sleep(5000);

        //navigate forward
        driver.navigate().forward();

        //refresh
        driver.navigate().refresh();

        //closes the google chrome
        driver.close(); //Process finished with exit code 0

        driver.quit();//kills the webdriver

    }

}
