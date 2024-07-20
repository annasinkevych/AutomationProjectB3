package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class T0_iframe_practice extends TestBase {

    /*
    go to https://loopcamp.vercel.app/nexted-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"
     */
    private WebElement parentFrame;


    @Test
    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        //searching by WebElement
        WebElement parentFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        //driver.switchTo().frame("frame-top"); //searching by name
        //driver.switchTo().frame(1);//search by index
        driver.switchTo().frame(parentFrame);//located parent frame
        driver.switchTo().frame("frame-left");//now we locate and switch to child frame
        //find element with text LEFT and save it into the WebElement left
        WebElement left = driver.findElement(By.xpath("//*[contains(text(), 'LEFT')]"));
        String actual = left.getText();
        String expected = "LEFT";
        assertEquals(actual, expected, "Actual text is incorrect. Actual: \"" + actual + "\" Expected: \"" + expected + "\"");

    }
    @Test
    public void iframeTest(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");

        //locate parent iframe 1
        parentFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
    }
}
