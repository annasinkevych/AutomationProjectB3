package io.loop.homework.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class task1 extends TestBase {

    /*Practice Task
=============


    task1
=============
    go to https://loopcamp.vercel.app/nested-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

    3 ways to locate iframes:
        //searching by WebElement
        WebElement parentFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        //searching by name
        driver.switchTo().frame("frame-top");
        //search by index
        driver.switchTo().frame(1);
*/

    private WebElement parentFrame;
    String expected;

    @Test
    public void iframes(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        //searching by WebElement
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));//located and switched to parent frame
        driver.switchTo().frame("frame-left"); //now we've located and switched to child frame
        //find element with text LEFT and save it into the WebElement left
        expected = "LEFT";
        assertion((driver.findElement(By.xpath("//*[contains(text(), 'LEFT')]"))).getText(), expected);

        //step out of the child frame left to parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        //find element with text MIDDLE and save it into the WebElement middle
        expected = "MIDDLE";
        assertion(driver.findElement(By.xpath("//*[contains(., 'MIDDLE')]")).getText(), expected);
        //step out of the child frame middle to parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        expected = "RIGHT";
        assertion(driver.findElement(By.xpath("//*[contains(., 'RIGHT')]")).getText(), expected);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        expected = "BOTTOM";
        assertion(driver.findElement(By.xpath("//*[contains(., 'BOTTOM')]")).getText(), expected);

    }

    public void assertion(String actual, String expected) {
        String message = "Actual text: " + actual + " DOES NOT MATCH EXPECTED: " + expected;
        assertEquals(actual, expected, message);
    }



}
