package io.loop.test.day3;

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
        driver.manage().window().maximize();

        //get the title of the page
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);//returns String "Google"

        if(actualTitle.contains(expectedTitle)) {
            System.out.println("Actual title: " + actualTitle + " matches expected title: " + expectedTitle + "=> TEST PASS");
        }
        else
        {
            System.out.println("Actual title: " + actualTitle + " DOES NOT match expected title: " + expectedTitle + "=> TEST FAIL");
        }

        System.out.println(driver.getCurrentUrl()); //returns a current url of the webpage that we are testing at this point of code

        String expectedUrl = "https://www.google.com/";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.equals(expectedUrl)) {
            System.out.println("Actual URL: " + actualUrl + " matches expected URL: " + expectedUrl + " => TEST PASS");
        }
        else
        {
            System.out.println("Actual URL: " + actualUrl + " DOES NOT match expected URL: " + expectedUrl + "=> TEST FAIL");
        }
        driver.quit();



    }
}
