package io.loop.homework.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class Task2Demoqa extends TestBase {

 /*
    go to https://demoqa.com/nestedframes
    Validate "Child Iframe" text
    Validate "Parent Iframe" text
    Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspector or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
     */

    @Test
    public void frameTest(){

        driver.get("https://demoqa.com/nestedframes");

        //locate parent iframe
        WebElement parentFrameXpath = driver.findElement(By.xpath("//iframe[@id='frame1']"));

        //step into parent frame
        driver.switchTo().frame(parentFrameXpath);

        //locate text element of the parent frame
        WebElement parentTextElement = driver.findElement(By.xpath("//body"));

        String actual = parentTextElement.getText();
        String expected = "Parent frame";

        //validate parent text
        assertEquals(actual,expected, "Actual: " + actual + " DOES NOT match expected: " + expected + " =>TEST FAILED");

        //locate child frame
        WebElement childFrameXpath = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));

        driver.switchTo().frame(childFrameXpath);
        WebElement childFrameTextElement = driver.findElement(By.xpath("//body"));
        actual = childFrameTextElement.getText();
        expected = "Child Iframe";

        assertEquals(actual, expected,"Actual: " + actual + " DOES NOT match expected: " + expected + " =>TEST FAILED" );

        driver.switchTo().parentFrame();


    }
}
