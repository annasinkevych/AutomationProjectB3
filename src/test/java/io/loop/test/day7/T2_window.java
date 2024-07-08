package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.Set;

public class T2_window extends TestBase {

    /*
    1. Create new test and make set ups
    2. Go to : https://www.amazon.com
    3. Copy paste the lines from below into your class
    4. Create a logic to switch to the tab where Etsy.com is open
    5. Assert: Title contains “Etsy”
    Lines to be pasted:
    ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    These lines will simply open new tabs using something called JavascriptExecutor
     */

    @Test
    public void windowHandleTest(){
        driver.get("https://www.amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


//        Set<String> windowHandles = driver.getWindowHandles();//gets a set of unique ID of windowhandles
//
//        for(String window: windowHandles){
//            driver.switchTo().window(window); //go to the ID of the windowHandle sent
//            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
//
//            if(driver.getCurrentUrl().toLowerCase().contains("etsy")){
//                break;
//            }
//        }


        BrowserUtils.switchWindowAndValidate(driver, "etsy.com", "Etsy");
        //comes back to google and stops there
        BrowserUtils.switchToWindow(driver, "anna");
    }



}
