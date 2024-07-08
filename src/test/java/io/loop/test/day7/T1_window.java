package io.loop.test.day7;

import io.loop.test.base.TestBase;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Set;

public class T1_window extends TestBase {
    /*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */

    @Test
    public void test_window_handle(){
        driver.get("http://the-internet.herokuapp.com/windows");
        assertEquals(driver.getTitle(), "The Internet", "Results are NOT matching!");

        System.out.println(driver.getWindowHandle() + " this is a window's unique ID"); //windowhandle window's unique ID

        WebElement clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickHere.click();

        //we need to switch to a new window
        System.out.println("Driver title = " + driver.getTitle());

        String originalWindow = driver.getWindowHandle();
        Set <String> windowHandles = driver.getWindowHandles();
//        driver.switchTo().window(WindowType.WINDOW.toString());

        //iterate through window handles
        for(String each : windowHandles){
            System.out.println("Each window handle is " + each);
            driver.switchTo().window(each);
        }

        //window handle allows jumping from one window to another using the return ID of each individual window handle

        //current title after all the iterations
        System.out.println("Driver title = " + driver.getTitle());

        //here I switch to the original one
        driver.switchTo().window(originalWindow);

        System.out.println("driver.getTitle() = " + driver.getTitle());


    }

    @Test
    public void selenium4_window(){
        driver.get("http://the-internet.herokuapp.com/windows");
        //opens a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());
        //opens a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());
    }
}
