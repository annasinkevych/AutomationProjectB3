package io.loop.test.day9;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class T3_JavaScript_Executor_scroll_page {

      /*
    1. Go to https://www.etsy.com
    2. Scroll down
    3. Generate random email and enter into subscribe box
    4. Click on Subscribe
    5. Verify "Great! We've sent you an email to confirm your subscription." is displayed
     */

    @Test
    public void etsy_scroll_test(){
/*
    Driver.getDriver():

    This method is likely part of a custom Driver class that provides a WebDriver instance. This WebDriver instance is used to interact with web browsers (like Chrome, Firefox, etc.) in automated tests.
    The getDriver() method returns an instance of WebDriver. This might be implemented as a singleton pattern to ensure only one instance of WebDriver is created and used throughout the tests.
    .get(ConfigurationReader.getProperties("etsy")):

    The get method of the WebDriver instance is used to navigate to a specific URL.
    ConfigurationReader.getProperties("etsy") is a method call that retrieves the URL associated with the key "etsy" from a configuration file. This file usually contains various key-value pairs for different properties used in the tests, such as URLs, credentials, and other settings.
 */
        Driver.getDriver().get(ConfigurationReader.getProperties("loopcamp"));
        WebElement link = Driver.getDriver().findElement(By.xpath("//a[@target='_blank']"));

        //How to scroll #1 using Actions
        Actions actions = new Actions(Driver.getDriver());
            //#1 use move to element
            //actions.moveToElement(link).perform();
            //#2 use
            //actions.scrollToElement(link).perform();

            //#3 use sendKeys
            //actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        //How to scroll #2 using JavaScript Executor
        //create a JS executor object(instance) and type cast our browser
        JavascriptExecutor jsExecutor = (JavascriptExecutor)Driver.getDriver();
        //window.scrollBy(x, y): This JavaScript function scrolls the window by the specified number of pixels.
        //x: The horizontal distance to scroll (in pixels). 0 means no horizontal scrolling.
        //y: The vertical distance to scroll (in pixels). 500 means scroll down by 500 pixels.
        jsExecutor.executeScript("window.scrollBy(0,500)");

        //scroll to view
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", link);

        //click with js click
        jsExecutor.executeScript("arguments[0].click()", link);

        //Window scroll method of JS executor interface
        jsExecutor.executeScript("window.scrollBy(0,500)");


//        Driver.closeDriver();


    }

}
