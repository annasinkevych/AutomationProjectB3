package io.loop.homework.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.time.Duration;

public class Task1 extends TestBase {
    /*
    go to https://demoqa.com/alerts
    click - click button to see alert
    handle alert
    click - On button click, alert will appear after 5 seconds
    handle alert
    click - On button click, confirm box will appear
    click ok and validate - You selected Ok
    after that do it again this time cancel and validate - You selected Cancel
    click - On button click, prompt box will appear
    enter "Loop Academy" and validate You entered Loop Academy
     */

    private Alert alert;
    private WebElement successMessage;
    private String actual, expected;


    @Test
    public void informationAlerts() throws InterruptedException {

        driver.get("https://demoqa.com/alerts");

        //locate information alert
        WebElement informationAlert1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
        informationAlert1.click();
        Thread.sleep(1000);
        //handle alert
        alert = driver.switchTo().alert();
        alert.accept(); //will click ok and accept the message

        //locate information alert 2
        WebElement informationAlert2 = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        informationAlert2.click();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(7000);
        //handle alert
        alert.accept();

    }

    @Test
    public void confirmationAlert(){
        driver.get("https://demoqa.com/alerts");

        //find confirmation element
        WebElement confirmationAlert = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmationAlert.click();

        //handle alert
        alert = driver.switchTo().alert();
        alert.accept();//will click ok and accept the message

        //validate success message
        successMessage = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        expected = "You selected Ok";
        actual = successMessage.getText();
        assertEquals(actual, expected, "Actual message" + actual + " DOES NOT MATCH EXPECTED: " + expected + "=> TEST FAILED");

        confirmationAlert.click();
        driver.switchTo().alert().dismiss();
        expected = "You selected Cancel";
        actual = successMessage.getText();
        assertEquals(actual, expected, "Actual message" + actual + " DOES NOT MATCH EXPECTED: " + expected + "=> TEST FAILED");

    }


    @Test
    public void promptAlert(){
        driver.get("https://demoqa.com/alerts");
        //locate and click the prompt button
        //These lines locate the button using XPath and simulate a click on it.

        WebElement promptAlert = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promptAlert.click();

        //Define the text to be entered into the prompt if any
        String text = "LoopCamp";
        alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        //Verify the success message
        successMessage = driver.findElement(By.xpath("//span[@id='promptResult']"));
        actual = successMessage.getText();
        expected = "You entered " + text;
        assertEquals(actual, expected,"Actual message" + actual + " DOES NOT MATCH EXPECTED: " + expected + "=> TEST FAILED" );

        //handle the js prompt again but dismiss, validate the message
//        promptAlert.click();
//        alert = driver.switchTo().alert();
//        alert.sendKeys(text);
//        alert.dismiss();
//        actual = successMessage.getText();
//        expected = null;
//        assertEquals(actual, expected, "Actual message" + actual + " DOES NOT MATCH EXPECTED: " + expected + "=> TEST FAILED");
    }


}
