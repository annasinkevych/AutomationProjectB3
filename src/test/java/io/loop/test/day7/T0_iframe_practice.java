package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T0_iframe_practice extends TestBase {

    /*
    go to https://loopcamp.vercel.app/nexted-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"
     */
    private WebElement parentFrame;

    @Test
    public void iframeTest(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");

        //locate parent iframe 1
        parentFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
    }
}
