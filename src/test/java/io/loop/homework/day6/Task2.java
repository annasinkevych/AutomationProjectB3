package io.loop.homework.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.channels.NotYetBoundException;

public class Task2 extends TestBase {
    /*
    go to https://loopcamp.vercel.app/nested-frames.html
    Validate "Child Iframe" text
    Validate "Parent Iframe" text
    Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
     */

    private WebElement parentFrame;
    private WebElement childFrame;
    private String actual, expected;
    private WebElement frameTextElement;

   @Test(priority = 1)
    public void frameTest(){
       driver.get("https://loopcamp.vercel.app/nested-frames.html");

       //locate parent iframe 1
       parentFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
       /**
      //or do it this way
//      driver.switchTo().frame("frame-top");
//      driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        String actualLeft = left.getText();

        Assert.assertEquals(actualLeft.trim(), "LEFT");
        **/


       //step into the frameset
       driver.switchTo().frame(parentFrame);

       //locate child frame #1 - Left
       childFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
       //step into a child frame #1
       driver.switchTo().frame(childFrame);

       //find text for frame 1 within the <body></body> tags and validate it
       WebElement frameTextElement  = driver.findElement(By.xpath("//body"));
       actual = frameTextElement.getText();
       expected = "LEFT";
       assertEquals(actual, expected,"Actual: " + actual + " DOES NOT match expected: " + expected + " =>TEST FAILED" );

       //step out of the child iframe into the parent iframe to get to the second child iframe
       driver.switchTo().parentFrame();

       //locate child iframe #2 - Middle
       childFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
       //step into child frame #2
       driver.switchTo().frame(childFrame);
       //find text for frame 2 within the <body></body> tags and validate it
       frameTextElement = driver.findElement(By.xpath("//div[@id='content']"));
       actual = frameTextElement.getText();
       expected = "MIDDLE";
       assertEquals(actual, expected, "Actual: " + actual + " DOES NOT match expected: " + expected + " =>TEST FAILED");

       //step out of the child iframe into the parent iframe to get to the second child iframe
       driver.switchTo().parentFrame();

       //locate child frame #3 - Right
       childFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));
       //step into child frame #3
       driver.switchTo().frame(childFrame);
       //find text for frame 3 within the <body></body> tags and validate it
       frameTextElement = driver.findElement(By.xpath("//body"));
       actual = frameTextElement.getText();
       expected = "RIGHT";
       assertEquals(actual, expected,"Actual: " + actual + " DOES NOT match expected: " + expected + " =>TEST FAILED");
   }

   @Test(priority = 2)
    public void frame2Test(){
       //locate parent frame 2
       driver.get("https://loopcamp.vercel.app/nested-frames.html");

       //step into parent frame 2
       parentFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));

       //step into frame 2
       driver.switchTo().frame(parentFrame);

       //find text element
       frameTextElement = driver.findElement(By.xpath("//body"));
       actual = frameTextElement.getText();
       expected = "BOTTOM";

       //validate the text
       assertEquals(actual, expected, "Actual: " + actual + " DOES NOT match expected: " + expected + " =>TEST FAILED");



   }
}
