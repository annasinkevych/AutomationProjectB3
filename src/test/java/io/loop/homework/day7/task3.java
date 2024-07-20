package io.loop.homework.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class task3 extends TestBase {

    /*
        task3
=============
        1. go to https://loopcamp.vercel.app/
            2. click "Multiple Windows" link
    3. Validate "Powered by Loopcamp" is displayed
    4. Validate title is "Windows"
            5. Click - click here
    6. Switch to new window and validate title

     */

    @Test
    public void multipleWindowsTest() throws InterruptedException {
        //1. go to https://loopcamp.vercel.app/
        driver.get("https://loopcamp.vercel.app/");

        //2. click "Multiple Windows" link
        driver.findElement(By.xpath("//a[contains(., \"Multiple Windows\")]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Validate "Powered by Loopcamp" is displayed
        WebElement poweredBy = driver.findElement(By.xpath("//a[.='LOOPCAMP']/.."));
        assertTrue(poweredBy.isDisplayed());

        //4. Validate title is "Windows"
        assertEquals(driver.getTitle(), "Windows", "Actual title: " + driver.getTitle() + " DOES NOT MATCH: " + "Windows");

        //5. Click - click here
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        Thread.sleep(3000);

        //6. Switch to new window and validate title
        BrowserUtils.switchToWindow(driver,"New Window" );
        assertEquals(driver.getTitle(), "New Window", "Actual title: " + driver.getTitle() + " DOES NOT MATCH: " + "New Window");

    }
}
