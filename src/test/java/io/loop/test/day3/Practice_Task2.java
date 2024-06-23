package io.loop.test.day3;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

public class Practice_Task2 {

    /*
      Task 2
    ================
    1. Open Chrome browser
    2. Go to https://www.etsy.com
    3. Search for “wooden spoon”
    4. Verify title:
    Expected: “Wooden spoon | Etsy”
     */
    public static void main(String[] args) {

        //create a webDriver - 1. Open Chrome browser
        WebDriver driver = WebDriverUtil.getDriver("chrome");

        //maximize
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //3. Search for “wooden spoon”
        WebElement searchBoxWitID = driver.findElement(By.id("global-enhancements-search-query"));

        String textToSeach = "wooden spoon";
        searchBoxWitID.sendKeys(textToSeach + Keys.ENTER);

        //4. Verify title: Expected: “Wooden spoon | Etsy”

        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("=> TEST PASS: actual title: \"" + actualTitle + "\" MATCHES expected title: \"" + expectedTitle + "\"");
        }
        else {
            System.out.println("=> TEST FAIL: actual title: \"" + actualTitle + "\"DOES NOT MATCH expected title: \"" + expectedTitle + "\"");
        }



    }
}
