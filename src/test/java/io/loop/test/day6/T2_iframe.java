package io.loop.test.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class T2_iframe extends TestBase {
/*
    1- Open a chrome browser
    2- Go to: https://loopcamp.vercel.app/iframe.html
    3- Clear text from comment body
    4- Type "Loop Academy" in comment body
    5- Verify "Loop Academy" text is written in comment body
    6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
     */

    @Test
    public void iframeTest() {
        driver.get("https://loopcamp.vercel.app/iframe.html");

        //locate header

//        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame')]"));
//        System.out.println(header.getText());
//
//        //locate text inside the box
//        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
//        System.out.println("textbox: " + textBox.getText()); //throws NoSuchElementException

        //to locate the iframe we do this:
        //#1 - with Locator xpath using WebElement
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe); //now we are inside this iframe, we switched to it
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']")); //located the textBox
        textBox.clear(); //cleared the textbox text

        textBox.sendKeys("Loop Academy");
        //validate the text there is "Loop Academy"
        assertEquals(textBox.getText(), "Loop Academy", "Actual DOES NOT MATCH expected.");
        driver.switchTo().defaultContent();//take me back to normal html where I was before stepping into the iframe
        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame')]"));//locate header
        System.out.println(header.getText());//get header element text
        assertTrue(header.isDisplayed(),"The header is not displayed.");


        //#2 - Index
        driver.switchTo().frame(0);//switch to index zero iframe


        //#3 - By ID
        driver.switchTo().frame("mce_0_ifr"); //switch to frame with this ID

    }

    @Test
    public void loopcampFrames(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        List<WebElement> iframes;
        iframes = driver.findElements(By.xpath("//frame"));
        System.out.println("iframes.size() = " + iframes.size());

    }
}
